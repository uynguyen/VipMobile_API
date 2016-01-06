/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.security.spec.KeySpec;
import java.sql.Timestamp;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turbo.POJO.RegisterToken;
import turbo.POJO.User;
import turbo.bussiness.EmailHandler;
import turbo.bussiness.GenerateTokenBus;
import turbo.bussiness.RegisterEmailHandler;
import turbo.model.AccessTokenModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import turbo.POJO.AccessToken;
import turbo.POJO.Account;
import turbo.POJO.ResetpassToken;
import turbo.bussiness.ResetPassEmailHandler;
import turbo.model.AccountModel;
import turbo.model.RegiterModel;
import turbo.model.ResetPassModel;
import turbo.model.UpdatePasswordModel;

/**
 *
 * @author LeeSan
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends RootService implements UserService {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RegisterTokenDAO registerTokenDAO;
    
    @Autowired
    private ResetPassTokenDAO resetpassTokenDAO;

    @Autowired
    private AccessTokenDAO accessTokenDAO;

    @Autowired
    private AccountDAO accountDAO;

    //TODO: Hash pass invalid???
    public String getUserByUsername(String username, String password, String role, AccessTokenModel token) {

        User user = userDAO.getUserByUsername(username);
        if (user == null) {
            return "Invalid Information";
        }
        if (role != null && role != "" && role.compareTo("admin") == 0) {
            String userRole = user.getIdRole().getRole().toLowerCase();
            if (userRole.compareTo("admin") != 0 && userRole.compareTo("superadmin") != 0) {
                return "Require permission";
            }
        }

        if (!user.getIsActive()) {
            return "Activated Require";
        }

        if (!comparePassword(username, password, user.getPassword())) {
            return "Invalid Information";
        }

        AccessTokenModel testtoken = GenerateTokenBus.generateToken(user.getUsername());

        AccessToken accessToken = new AccessToken();
        accessToken.setAccessToken(testtoken.getToken());
        accessToken.setExpire(testtoken.getExpireDate());
        accessToken.setUserId(user);
        accessToken.setScope("None");

        accessToken = accessTokenDAO.create(accessToken);

        if (accessToken != null) {
            token.setToken(testtoken.getToken());
            token.setExpireDate(testtoken.getExpireDate());
            System.out.println(user.getIdAccount().toString());
            AccountModel accModel = accountPOJO2Model(user.getIdAccount());
            accModel.setEmail(user.getEmail());
            token.setAcc(accModel);
            return "Success";
        }
        return "Fail";
    }

    protected Object JsonToModel(String array, Object template) {

        Object result = new Object();
        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(array,
                    TypeFactory.defaultInstance().constructType(template.getClass()));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return result;
    }

    public User getProduct(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String updateUser(AccountModel accountModel) {

        try {
            Account acc = accountDAO.get(accountModel.getId());
            if (acc != null) {
                acc.setAddress(accountModel.getAddress());
                acc.setBirthday(new Date(accountModel.getBirthday()));
                acc.setFullName(accountModel.getFullName());
                acc.setGender(accountModel.getGender());
                acc.setVisaCode(accountModel.getVisaCode());
                accountDAO.update(acc);
                return "Success";
            }
            return "Not found";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error" + e.getMessage();
        }
    }

    public void deleteUser(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //TODO: Set user role
    public String registerUser(RegiterModel userModel) {
        if(userModel.getPassword() == "" || userModel.getPassword() == null || userModel.getEmail() == null ||
                userModel.getEmail() == "" || userModel.getUsername() == null || userModel.getUsername() == "")
            return "Error";
        if (isExistUsername(userModel.getUsername())) {
            return "UserNameExisted";
        }
        if (isExistEmail(userModel.getEmail())) {
            return "EmailExisted";
        }
        User user = new User();
        user.setUsername(userModel.getUsername());
        user.setEmail(userModel.getEmail());
        user.setIsActive(false);
        user.setCreateDate(new Date());
        user.setPassword(hashPass(userModel.getUsername(), userModel.getPassword()));
        User result = (User) userDAO.create(user);
        if (result != null) {
            AccessTokenModel accToken = GenerateTokenBus.generateToken(result.getUsername());
            RegisterToken registerToken = new RegisterToken();
            registerToken.setIdUser(result);
            registerToken.setAccessToken(accToken.getToken());
            registerToken.setExpise(accToken.getExpireDate());

            if (registerTokenDAO.create(registerToken) != null) {
                EmailHandler sendEmailHandler = new RegisterEmailHandler(userModel.getCallbackURL() + accToken.getToken(), userModel.getUsername());

                sendEmailHandler.sendEmail(user.getEmail());
                return "CreateSuccess";
            }

        }

        return "CreateFail";

    }

    private String hashPass(String username, String password) {
        try {

            byte[] salt = new byte[16];
            salt = username.getBytes();
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = f.generateSecret(spec).getEncoded();

            String s1 = DatatypeConverter.printBase64Binary(salt);
            String s2 = DatatypeConverter.printBase64Binary(hash);
            return s2;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public boolean isExistUsername(String username) {

        User user = userDAO.getUserByUsername(username);
        return (user != null);
    }

    @Override
    public boolean isExistEmail(String email) {
        User user = userDAO.getUserByEmail(email);
        if (user != null) {
            return (user.getIsActive() == true);
        }

        return false;
    }

    public String activateUser(String registerToken) {

        RegisterToken token = registerTokenDAO.getRegisterToken(registerToken);
        if (token == null) {
            return "NotExist";
        }

        Timestamp currentTime = new Timestamp(new Date().getTime());
        if (token.getExpise().compareTo(currentTime) < 0) { //Expire
            return "Expire";
        }
        User user = token.getIdUser();
        if (user.getIsActive()) {
            return "Was activated";
        }
        User checkedUser = userDAO.getUserByEmail(user.getEmail());
        if(checkedUser != null){
            return "Error! Email was used";
        }
        
        Account acc = new Account();
        acc.setAvatar("Default");
        acc = accountDAO.create(acc);
        user.setIdAccount(acc);
        user.setIsActive(true);
        userDAO.update(user);
        return "Activated";

    }

    @Override
    public String sendResetRequestEmail(String email, String callbackURL) {
        
        User user = userDAO.getUserByEmail(email);
        
        if(user == null || !user.getIsActive()){
            return "User not exist";
        }
        
    
        AccessTokenModel accToken = GenerateTokenBus.generateToken(user.getUsername());
        ResetpassToken resetpassToken = new ResetpassToken();
        resetpassToken.setIdUser(user);
        resetpassToken.setAccessToken(accToken.getToken());
        resetpassToken.setExpire(accToken.getExpireDate());

        if (resetpassTokenDAO.create(resetpassToken) != null) {
            EmailHandler sendEmailHandler = new ResetPassEmailHandler(callbackURL + accToken.getToken(), user.getUsername());

            sendEmailHandler.sendEmail(user.getEmail());
            return "Sent";
        }

        
        return "Error create reset pass token";
    }

    @Override
    public String updatePassword(UpdatePasswordModel updatePasswordModel, String token) {
        AccessToken accessToken = accessTokenDAO.getAccessToken(token);
        User user = accessToken.getUserId();
        boolean checkOldPass = comparePassword(user.getUsername(), updatePasswordModel.getOldPass(), user.getPassword());
        if (!checkOldPass) {
            return "Invalid Information";
        }
        return updatePass(user, updatePasswordModel.getNewPass());
    }

    private String updatePass(User user, String password) {
        try {
            user.setPassword(hashPass(user.getUsername(), password));
            userDAO.update(user);
            return "Updated";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error" + e.getMessage();
        }
    }

    private boolean comparePassword(String username, String oldPass, String password) {
        String hashPass = hashPass(username, oldPass);
        if (!hashPass.equals(password)) {
            return false;
        }
        return true;
    }

    @Override
    public String resetPass(ResetPassModel password, String resetPassToken) {
        if(password.getNewPass().compareTo(password.getRetypePass()) != 0) {
            return "Password not match";
        }
        ResetpassToken token = resetpassTokenDAO.getResetpassToken(resetPassToken);
        if (token == null) {
            return "Not Exist";
        }

        Timestamp currentTime = new Timestamp(new Date().getTime());
        if (token.getExpire().compareTo(currentTime) < 0) { //Expire
            return "Expire";
        }
        User user = token.getIdUser();
        updatePass(user, password.getNewPass());
//        resetpassTokenDAO.delete(token);
        token.setAccessToken("");
        resetpassTokenDAO.update(token);
        return "Reseted";
    }


}
