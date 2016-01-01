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
import turbo.POJO.RegisterToken;
import turbo.POJO.User;

/**
 *
 * @author LeeSan
 */
@Repository
public class HbnRegisterTokenDAO extends AbstractHbnDAO<RegisterToken> implements RegisterTokenDAO{
    @Override
    public RegisterToken getRegisterToken(String token) {
        Session ss = getSession();
        ss.beginTransaction();
        Query query = ss.getNamedQuery("RegisterToken.findByAccessToken");
        query.setString("accessToken", token);
        List<RegisterToken> result = query.list();
       // ss.close();
        if (result.size() != 0) {
            return (RegisterToken) result.get(0);
        }
        return null;
        
    }
}
