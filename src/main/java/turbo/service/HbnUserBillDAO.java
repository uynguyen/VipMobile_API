/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import turbo.POJO.ProductDetail;
import turbo.POJO.UserBill;

/**
 *
 * @author LeeSan
 */
@Repository
public class HbnUserBillDAO extends AbstractHbnDAO<UserBill> implements UserBillDAO {

    @Override
    public ArrayList<UserBill> getUserBilḷ̣(int page, int limit) {
        ArrayList<UserBill> result = new ArrayList<>();
        Session ss = getSession();

        ss.beginTransaction();

        result = (ArrayList<UserBill>) ss.getNamedQuery("UserBill.findAll").setFirstResult(page * limit).setMaxResults(limit).list();

        return result;

    }

    @Override
    public ArrayList<UserBill> getUserBillByUsernamẹ(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<UserBill> getUserBillByCode(String billCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<UserBill> getUserBillByDate(String bookDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
