/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import org.springframework.stereotype.Repository;
import turbo.POJO.Product;
import turbo.POJO.User;

/**
 *
 * @author LeeSan
 */
@Repository
public class HbnUserDAO extends AbstractHbnDAO<User> implements UserDAO {

    @Override
    public User getUserByUsername(String username) {
        Session ss = getSession();
        ss.beginTransaction();
        Query query = ss.getNamedQuery("User.findByUsername");
        query.setString("username", username);
        List<User> result = query.list();
        ss.close();
        if (result.size() != 0) {
            return (User) result.get(0);
        }
        return null;

    }

    @Override
    public User getUserByEmail(String email) {
        Session ss = getSession();
        ss.beginTransaction();
        Query query = ss.getNamedQuery("User.findByEmail");
        query.setString("email", email);
        List<User> result = query.list();
        ss.close();

        if (result.size() != 0) {
            return (User) result.get(0);
        }
        return null;

    }
}
