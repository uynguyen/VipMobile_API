/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import turbo.POJO.Product;
import turbo.POJO.ProductDetail;
import turbo.POJO.RegisterToken;
import turbo.POJO.User;

/**
 *
 * @author LeeSan
 */
@Repository
public class HbnSingleProductDAO extends AbstractHbnDAO<ProductDetail> implements SingleProductDAO {

    public ProductDetail getProductDetail(int idProduct) {
        ProductDetail result = null;
        Session ss = getSession();
        ss.beginTransaction();
        Query query = ss.getNamedQuery("Product.findById");
        query.setInteger("id", idProduct);
        Product product = (Product) query.uniqueResult();
        Collection detail = product.getProductDetailCollection();
        if (!detail.isEmpty()) {
            result = (ProductDetail) detail.toArray()[0];
        }

        // ss.close();
        return result;

    }

   

}
