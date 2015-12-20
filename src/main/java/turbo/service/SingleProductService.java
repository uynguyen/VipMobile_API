/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import turbo.POJO.ProductDetail;
import turbo.POJO.User;

/**
 *
 * @author LeeSan
 */
public interface SingleProductService {
     ProductDetail getProductDetail(int idProduct);
}
