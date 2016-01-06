/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import turbo.POJO.ProductDetail;
import turbo.POJO.UserBill;

/**
 *
 * @author LeeSan
 */
@Transactional
@Repository
public class HbnUserBillDAO extends AbstractHbnDAO<UserBill> implements UserBillDAO {

    @Override
    public ArrayList<UserBill> getUserBilḷ̣(Integer page, Integer limit) {
        ArrayList<UserBill> result = new ArrayList<UserBill>();
        Session ss = getSession();

        ss.beginTransaction();

        Criteria criteria = ss.createCriteria(UserBill.class);
        criteria.addOrder(Order.asc("id"));
        if (page != null && limit != null) {
            criteria.setFirstResult(page * limit);
            criteria.setMaxResults(limit);
        }

        result = (ArrayList<UserBill>) criteria.list();

        //ss.close();
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
        ArrayList<UserBill> result = new ArrayList<UserBill>();
        try {

            Session ss = getSession();

            ss.beginTransaction();

            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

            Date exactDate = df.parse(bookDate);

            Query query = ss.createQuery("SELECT u FROM UserBill u WHERE DATE(u.bookDate) = :bookDate");
            query.setDate("bookDate", exactDate);

            result = (ArrayList<UserBill>) query.list();
            System.out.println(result.size());
            //ss.close();

        } catch (ParseException ex) {
            Logger.getLogger(HbnUserBillDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return result;
    }

    @Override
    public ArrayList<UserBill> getUserBilḷ̣() {
        return getUserBilḷ̣(null, null);
    }

    @Override
    public ArrayList<UserBill> getUserBilḷ̣ByIdUser(Integer page, Integer limit, Integer idUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
