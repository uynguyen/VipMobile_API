/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import turbo.POJO.Product;
import turbo.POJO.ProductDetail;
import turbo.POJO.SaleProduct;

/**
 *
 * @author LeeSan
 */
@Repository
public class HbnSaleProductDAO extends AbstractHbnDAO<SaleProduct> implements SaleProductDAO {

    @Override
    public ArrayList<SaleProduct> getSaleProducts(int page, int limit) {
        ArrayList<SaleProduct> result = new ArrayList<SaleProduct>();
        Session ss = getSession();
        ss.beginTransaction();
        Query query = ss.getNamedQuery("SaleProduct.findAll");
//        ArrayList<SaleProduct> saleProduct = (ArrayList<SaleProduct>) query.setFirstResult(page * limit).setMaxResults(limit).list();
//        for(SaleProduct item : saleProduct){
//            result.add(item.getIdProduct());
//        }
        result = (ArrayList<SaleProduct>) query.setFirstResult(page * limit).setMaxResults(limit).list();
        ss.close();
        return result;
    }

}
