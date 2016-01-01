/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turbo.POJO.Product;
import turbo.POJO.RegisterToken;
import turbo.POJO.User;
import turbo.bussiness.EmailHandler;
import turbo.bussiness.GenerateTokenBus;
import turbo.bussiness.RegisterEmailHandler;
import turbo.model.AccessTokenModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import turbo.POJO.AccessToken;
import turbo.bussiness.ResetPassEmailHandler;
import turbo.model.AccountModel;

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
    private AccessTokenDAO accessTokenDAO;

    public void addNewUSer(User product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //TODO: Hash pass invalid???
    public String getUserByUsername(String username, String password, String role, AccessTokenModel token) {

        User user = userDAO.getUserByUsername(username);
        if (user == null) {
            return "Invalid Infomation";
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

//        String hashPass = hashPass(username, password);
//        if (!hashPass.equals(user.getPassword())) {
//            return "Invalid Information";
//        }
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
            token.setAcc(accountPOJO2Model(user.getIdAccount()));
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

    public void updateUser(User product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteUser(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //TODO: Set user role
    public String registerUser(User user) {
        if (isExistUsername(user.getUsername())) {
            return "UserNameExisted";
        }
        if (isExistEmail(user.getEmail())) {
            return "EmailExisted";
        }
        user.setIsActive(false);
        user.setPassword(encoder.encode(user.getPassword()));
        User result = (User) userDAO.create(user);
        if (result != null) {
            AccessTokenModel accToken = GenerateTokenBus.generateToken(result.getUsername());
            RegisterToken registerToken = new RegisterToken();
            registerToken.setIdUser(result);
            registerToken.setAccessToken(accToken.getToken());
            registerToken.setExpise(accToken.getExpireDate());

            if (registerTokenDAO.create(registerToken) != null) {
                EmailHandler sendEmailHandler = new RegisterEmailHandler();

                sendEmailHandler.sendEmail(user.getEmail());
                return "CreateSuccess";
            }

        }

        if (userDAO.create(user) != null) {
            return "CreateSuccess";
        }
        return "CreateFail";

    }

    private String hashPass(String username, String password) {
        try {

            byte[] salt = new byte[16];
            salt = username.getBytes();
            KeySpec spec = new PBEKeySpec("password".toCharArray(), salt, 65536, 128);
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = f.generateSecret(spec).getEncoded();
            Base64.Encoder enc = Base64.getEncoder();
            String s1 = enc.encodeToString(salt);
            String s2 = enc.encodeToString(hash);
            return s2;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean isExistUsername(String username) {

        User user = userDAO.getUserByUsername(username);
        return (user == null) ? false : true;
    }

    public boolean isExistEmail(String email) {
        User user = userDAO.getUserByEmail(email);
        if (user != null) {
            return (user.getIsActive() == true) ? true : false;
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
        user.setIsActive(true);
        userDAO.update(user);
        return "Activated";

    }

    public String sendResetRequestEmail(String email) {
        EmailHandler sendEmailHandler = new ResetPassEmailHandler();

        boolean result = sendEmailHandler.sendEmail(email);
        return "Sent";
    }

}
