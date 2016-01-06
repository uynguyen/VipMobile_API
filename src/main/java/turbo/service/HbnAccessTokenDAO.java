/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import turbo.POJO.AccessToken;
import turbo.POJO.Product;
import turbo.POJO.User;

/**
 *
 * @author LeeSan
 */
@Transactional
@Repository
public class HbnAccessTokenDAO extends AbstractHbnDAO<AccessToken> implements AccessTokenDAO {

    public AccessToken getAccessToken(String token) {
        Session ss = getSession();
        ss.beginTransaction();
        Query query = ss.getNamedQuery("AccessToken.findByAccessToken");
        query.setString("accessToken", token);
        List<AccessToken> result = query.list();
       // ss.close();
        if (result.size() != 0) {
            return (AccessToken) result.get(0);
        }
        return null;
    }

}
