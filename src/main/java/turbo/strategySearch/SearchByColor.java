/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.strategySearch;

import java.util.ArrayList;
import java.util.Collection;
import turbo.POJO.ColorCategory;
import turbo.POJO.ProducerCategory;
import turbo.POJO.Product;
import turbo.POJO.ProductColorDetail;
import turbo.POJO.ProductDetail;
import turbo.model.QueryProductStringModel;
import turbo.service.ColorDAO;
import turbo.service.ProductDAO;

/**
 *
 * @author LeeSan
 */
public class SearchByColor implements StrategySearch {

    private ProductDAO productDAO;
    private ColorDAO colorDAO;

    public SearchByColor(ColorDAO dao, ProductDAO productDAO) {
        this.colorDAO = dao;
        this.productDAO = productDAO;
    }

    public ArrayList<Product> Search(ArrayList<Product> lstProducts, QueryProductStringModel query, boolean flag_isFirstTime) {
        ArrayList<Product> result = new ArrayList<Product>();
        if (!flag_isFirstTime) {
            for (Product p : lstProducts) {
                p = productDAO.get(p.getId());
                Collection<ProductColorDetail> detail = p.getProductColorDetailCollection();
                if (detail != null && detail.toArray().length != 0) {
                    for (int i = 0; i < detail.toArray().length; i++) {
                        String colorValue = ((ProductColorDetail) detail.toArray()[i]).getIdColor().getValue();
                        if (query.getColors().contains(colorValue)) {
                            result.add(p);
                        }
                    }

                }
            }
            return result;
        }

        for (String colorValue : query.getColors()) {
            ColorCategory colorCategory = colorDAO.getProductColorDetailByValue(colorValue);
            if (colorCategory != null) {
                Collection<ProductColorDetail> productDetailBelongToColor = colorCategory.getProductColorDetailCollection();
                if (productDetailBelongToColor != null && productDetailBelongToColor.size() != 0) {
                    for (int i = 0; i < productDetailBelongToColor.size(); i++) {
                        ProductColorDetail detail = (ProductColorDetail) productDetailBelongToColor.toArray()[i];
                        Product p = detail.getIdProduct();
                        if (p != null) {
                            result.add(p);
                        }
                    }
                }
            }
        }

        return result;
    }

}
