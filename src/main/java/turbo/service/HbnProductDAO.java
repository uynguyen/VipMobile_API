/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.List;
import turbo.POJO.Product;

/**
 *
 * @author LeeSan
 */
public class HbnProductDAO extends AbstractHbnDAO<Product> implements ProductDAO {

    @Override
    public List<Product> findByEmail(String email) {
        return getSession()
                .getNamedQuery("findContactsByEmail")
                .setString("email", "%" + email + "%")
                .list();
    }

}
