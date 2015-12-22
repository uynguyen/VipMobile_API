/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.strategySearch;

import java.util.ArrayList;
import turbo.POJO.Product;
import turbo.POJO.ProductDetail;
import turbo.model.QueryProductStringModel;
import turbo.service.ColorDAO;
import turbo.service.ProductDAO;
import turbo.service.SingleProductDAO;

/**
 *
 * @author LeeSan
 */
public class SearchByScreenSize implements StrategySearch {

    private ProductDAO productDAO;

    public SearchByScreenSize(ProductDAO dao) {
        this.productDAO = dao;
    }

    public ArrayList<Product> Search(ArrayList<Product> lstProducts, QueryProductStringModel query) {
        ArrayList<Product> result = new ArrayList<Product>();

        if (!lstProducts.isEmpty()) {
            for (Product p : lstProducts) {
                if (p.getProductDetailCollection() != null && !p.getProductDetailCollection().isEmpty()) {
                    double screenSize = ((ProductDetail) p.getProductDetailCollection().toArray()[0]).getScreenSize();
                    if (query.getScreenSize().contains(screenSize)) {
                        result.add(p);
                    }
                }
            }

            return result;
        }
        result = productDAO.getProductByScreenSize(query.getScreenSize());
        return result;
    }

}
