/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import turbo.POJO.AccessToken;
import turbo.POJO.Product;
import turbo.POJO.ProductDetail;

/**
 *
 * @author LeeSan
 */
@Repository
public class HbnProductDAO extends AbstractHbnDAO<Product> implements ProductDAO {

    public ArrayList<Product> getProductByPriceArrange(int min, int max) {
        ArrayList<Product> result = new ArrayList<Product>();
        Session ss = getSession();
        ss.beginTransaction();

        Query query = ss.createQuery("SELECT p FROM Product p WHERE p.price >= :min AND p.price <= :max");
        query.setInteger("min", min);
        query.setInteger("max", max);

        result = (ArrayList<Product>) query.list();
        ss.close();
        return result;

    }

    public ArrayList<Product> getProductByScreenSize(ArrayList<Double> screenSize) {
        ArrayList<Product> result = new ArrayList<Product>();

        Session ss = getSession();
        ss.beginTransaction();

        String sql = "SELECT p FROM ProductDetail p WHERE ";
        for (Double size : screenSize) {
            sql = sql + "p.screenSize = " + size;
            if (screenSize.indexOf(size) < screenSize.size() - 1) {
                sql += " OR ";
            }
        }

        Query query = ss.createQuery(sql);

        List<ProductDetail> detail = query.list();
        if (!detail.isEmpty()) {
            for (int i = 0; i < detail.size(); i++) {
                ProductDetail item = (ProductDetail) detail.toArray()[i];
                result.add(item.getIdProduct());
            }
        }
        ss.close();
        return result;
    }

    public ArrayList<Product> getProducts(int page, int limit) {
        ArrayList<Product> result = new ArrayList<Product>();
        Session ss = getSession();
        ss.beginTransaction();
        Query query = ss.createQuery("SELECT p FROM Product p ORDER BY p.price ASC");

        result = (ArrayList<Product>) query.setFirstResult(page * limit).setMaxResults(limit).list();
        ss.close();
        return result;
    }

    public ArrayList<Product> getProductsByName(String searchString) {
        ArrayList<Product> result = new ArrayList<Product>();
        Session ss = getSession();
        ss.beginTransaction();
        result = (ArrayList<Product>) ss.createCriteria(Product.class).add(Restrictions.like("name", searchString, MatchMode.ANYWHERE)).list();
        ss.close();
        return result;
    }

    @Override
    public List<Product> getNewProduct(int page, int limit) {
        ArrayList<Product> result = new ArrayList<Product>();
        Session ss = getSession();
        ss.beginTransaction();
        Query query = ss.createQuery("SELECT p FROM Product p ORDER BY p.importDate DESC");

        result = (ArrayList<Product>) query.setFirstResult(page * limit).setMaxResults(limit).list();
        ss.close();
        return result;
    }

    @Override
    public List<Product> getHighProduct(int limit) {
         ArrayList<Product> result = new ArrayList<Product>();
        Session ss = getSession();
        ss.beginTransaction();
        Query query = ss.createQuery("SELECT p FROM Product p ORDER BY p.price DESC");

        result = (ArrayList<Product>) query.setFirstResult(0).setMaxResults(limit).list();
        ss.close();
        return result;
    }

}
