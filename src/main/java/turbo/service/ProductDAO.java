/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import java.util.List;
import turbo.POJO.Product;

/**
 *
 * @author LeeSan
 */
public interface ProductDAO extends DAO<Product>{

    public ArrayList<Product> getProductByPriceArrange(int min, int max);
    public ArrayList<Product> getProductByScreenSize(ArrayList<Double> screenSize);
    
    public ArrayList<Product> getProducts(int page, int limit);

    public ArrayList<Product> getProductsByName(String searchString);
   
  
}
