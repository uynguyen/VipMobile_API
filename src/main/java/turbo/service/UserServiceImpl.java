/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

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

    public void addNewUSer(User product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User getUserByUsername(String username, String password) {
        User result = null;

        userDAO.getUserByUsername(username);

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

    public String registerUser(User user) {
        if (isExistUsername(user.getUsername())) {
            return "UserNameExisted";
        }
        if (isExistEmail(user.getEmail())) {
            return "EmailExisted";
        }
        user.setIsActive(false);
        User result = (User) userDAO.create(user);
        if (result != null) {
            AccessTokenModel accToken = GenerateTokenBus.generateToken(result.getUsername());
            RegisterToken registerToken = new RegisterToken();
            registerToken.setIdUser(result);
            registerToken.setAccessToken(accToken.getToken());
            registerToken.setExpise(accToken.getExpireDate());

            if (registerTokenDAO.create(registerToken) != null) {
                EmailHandler sendEmailHandler = new RegisterEmailHandler();

                sendEmailHandler.sendEmail("uynguyen.itus@gmail.com");
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
        User user = userDAO.getUserByUsername(email);
        if (user != null) {
            return (user.getIsActive() == true) ? true : false;
        }

        return false;
    }

}
