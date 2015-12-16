/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import turbo.POJO.Product;
import turbo.POJO.User;

/**
 *
 * @author LeeSan
 */
@Repository
public class HbnUserDAO extends AbstractHbnDAO<User> implements UserDAO{
    @Override
    public User getUserByUsername(String username) {
        Session ss = getSession();
        ss.beginTransaction();
        List<User> result = ss.getNamedQuery("findByUsername")
                .setString("username", "%" + username + "%")
                .list();
      
        ss.close();
        return result.get(0);
                
                
    }
}
