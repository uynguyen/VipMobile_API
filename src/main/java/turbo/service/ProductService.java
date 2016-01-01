/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import java.util.List;
import turbo.POJO.ColorCategory;
import turbo.POJO.ProducerCategory;
import turbo.POJO.Product;
import turbo.POJO.SaleProduct;
import turbo.model.ArrayObjectModel;
import turbo.model.QueryProductStringModel;

/**
 *
 * @author LeeSan
 */
public interface ProductService {

    List<Product> getProducts(int page, int limit);

    List<Product> getBestSaleProduct(int page, int limit);

    Product getProduct(Integer id);

    ArrayObjectModel searchProduct(QueryProductStringModel query);

    public List<SaleProduct> getSaleProducts(int page, int limit);

    ArrayList<ProducerCategory> getProducerCategory();

    ArrayList<ColorCategory> getColorCategory();
    
    List<Product> getNewProduct(int page, int limit);

    public List<Product> getHighProduct(int limit);
}
