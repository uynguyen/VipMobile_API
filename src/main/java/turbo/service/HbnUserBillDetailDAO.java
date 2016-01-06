/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.hibernate.type.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import turbo.POJO.BillDetail;
import turbo.POJO.Product;
import turbo.POJO.UserBill;

/**
 *
 * @author LeeSan
 */
@Transactional
@Repository
public class HbnUserBillDetailDAO extends AbstractHbnDAO<BillDetail> implements UserBillDetailDAO {

    @Override
    public List<Product> getBestSaleProducts(int page, int limit) {

        ArrayList<Product> result = new ArrayList<Product>();
        Session ss = getSession();
        ss.beginTransaction();
        
//        Query q = ss.createSQLQuery("SELECT idProduct, SUM (amount) AS total FROM BillDetail GROUP BY idProduct ORDER BY total DESC");
//        ArrayList<Object> test = (ArrayList<Object>) q.list();
//        System.out.println("TEST" +  test.size());
//        
        
        
//        Criteria query = ss.createCriteria(BillDetail.class)
//                .setProjection(
//                        Projections.projectionList()
//                        .add(Projections.sum("amount"))
//                        .add(Projections.groupProperty("idProduct"))
//                        .add(Projections.sqlProjection(
//                                        "sum(amount) as amount, idProduct as product",
//                                        new String[]{"amount"},
//                                        new Type[]{StandardBasicTypes.INTEGER}), "amount")
//                )
//                .addOrder(Order.desc("amount"))
//                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//
//        List list = query.list();
//        
//        ArrayList<BillDetail> detail = (ArrayList<BillDetail>) query.setFirstResult(page * limit).setMaxResults(limit).list();
//        System.out.println("SIZEEEE" + detail.size());
//
//        for (BillDetail item : detail) {
//            result.add(item.getIdProduct());
//        }
//        //ss.close();
//        System.out.println("RESUT" + result.size());
        return result;
    }
}
