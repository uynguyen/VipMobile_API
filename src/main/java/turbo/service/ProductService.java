/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.List;
import turbo.POJO.Product;

/**
 *
 * @author LeeSan
 */
public interface ProductService {

    void createProduct(Product product);

    List<Product> getProducts();

    List<Product> getProductByCode(String code);

    Product getProduct(Long id);

    void updateProduct(Product product);

    void deleteProduct(Long id);
}
