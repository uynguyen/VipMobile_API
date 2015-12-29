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
import turbo.model.QueryProductStringModel;

/**
 *
 * @author LeeSan
 */
public interface ProductService {

    void createProduct(Product product);

    List<Product> getProducts();
    

    List<Product> getProductByCode(String code);

    Product getProduct(Integer id);

    void updateProduct(Product product);

    void deleteProduct(Long id);

    List<Product> searchProduct(QueryProductStringModel query);

    public List<SaleProduct> getSaleProducts(int page, int limit);
    
    ArrayList<ProducerCategory> getProducerCategory();
    ArrayList<ColorCategory> getColorCategory();
}
