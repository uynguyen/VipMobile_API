/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
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

        
        Criteria criteria = ss.createCriteria(UserBill.class);
        criteria.addOrder(Order.asc("id"));
        criteria.setFirstResult(page * limit);
        criteria.setMaxResults(limit);
        result = (ArrayList<UserBill>) criteria.list();
        System.out.println(result.get(1).getState());
        System.out.println(result.get(2).getState());
        ss.close();
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

