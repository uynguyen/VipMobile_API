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

/**
 *
 * @author LeeSan
 */
@Repository
public class HbnProductDAO extends AbstractHbnDAO<Product> implements ProductDAO {

    @Override
    public List<Product> findByEmail(String email) {
        Session ss = getSession();
        ss.beginTransaction();
        List<Product> result = ss.getNamedQuery("findContactsByEmail")
                .setString("email", "%" + email + "%")
                .list();
      
        ss.close();
        return result;
                
                
    }

}