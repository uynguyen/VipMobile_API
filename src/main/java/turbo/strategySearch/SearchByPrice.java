/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.strategySearch;

import java.util.ArrayList;
import turbo.POJO.Product;
import turbo.model.QueryProductStringModel;
import turbo.service.ProducerDAO;
import turbo.service.ProductDAO;

/**
 *
 * @author LeeSan
 */
public class SearchByPrice implements StrategySearch {

    private ProductDAO productDAO;

    public SearchByPrice(ProductDAO dao) {
        this.productDAO = dao;
    }

    @Override
    public ArrayList<Product> Search(ArrayList<Product> lstProducts, QueryProductStringModel query) {
        ArrayList<Product> result = new ArrayList<Product>();

        Integer minPrice = query.getMinPrice();
        Integer maxPrice = query.getMaxPrice();
        if (!lstProducts.isEmpty()) {
            for (Product p : lstProducts) {
                if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice) {
                    result.add(p);
                }

            }
            return result;
        }
        result = productDAO.getProductByPriceArrange(minPrice, maxPrice);
        return result;
    }

}
