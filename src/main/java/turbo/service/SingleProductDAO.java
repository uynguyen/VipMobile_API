/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import turbo.POJO.Product;
import turbo.POJO.ProductDetail;
import turbo.POJO.User;

/**
 *
 * @author LeeSan
 */
public interface SingleProductDAO extends DAO<ProductDetail>{
    ProductDetail getProductDetail(int idProduct);

    
}
