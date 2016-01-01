/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.strategySearch;

import java.util.ArrayList;
import turbo.POJO.Product;
import turbo.model.QueryProductStringModel;
import turbo.service.ProductDAO;

/**
 *
 * @author LeeSan
 */
public class SearchByStringQuery implements StrategySearch {

    ProductDAO productDAO;

    public SearchByStringQuery(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    
    
    
    public ArrayList<Product> Search(ArrayList<Product> lstProducts, QueryProductStringModel query, boolean flag_isFirstTime) {
        ArrayList<Product> result = new ArrayList<Product>();
        if (!flag_isFirstTime) {
            for (Product p : lstProducts) {

                if (p.getName().toLowerCase().contains(query.getSearchString().toLowerCase())) {
                    result.add(p);
                }

            }
        }
        result = productDAO.getProductsByName(query.getSearchString());
        return result;

    }

}
