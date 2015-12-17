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
import turbo.POJO.User;

/**
 *
 * @author LeeSan
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

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
        if(isExistUsername(user.getUsername())){
            return "UserNameExisted";
        }
        if(isExistEmail(user.getEmail())){
            return "EmailExisted";
        }
        user.setIsActive(false);
        
        if(userDAO.create(user))
            return "CreateSuccess";
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
