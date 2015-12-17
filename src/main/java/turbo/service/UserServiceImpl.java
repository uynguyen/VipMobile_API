/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turbo.POJO.User;

/**
 *
 * @author LeeSan
 */
@Service ("userService")
@Transactional
public class UserServiceImpl implements UserService{

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
    
}
