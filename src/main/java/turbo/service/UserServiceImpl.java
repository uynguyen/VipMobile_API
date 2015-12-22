/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

/**
 *
 * @author LeeSan
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private RegisterTokenDAO registerTokenDAO;
    
    @Autowired
    private AccessTokenDAO accessTokenDAO;
    
    public void addNewUSer(User product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getUserByUsername(String username, String password, AccessTokenModel token) {
        User user = userDAO.getUserByUsername(username);
        if (user == null) {
            return "Invalid Infomation";
        }
        
        if (!user.getIsActive()) {
            return "Activated Require";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        if (encoder.encode(password).equals(user.getPassword())) {
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
            return "Success";
        }
        return "Fail";
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
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
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
