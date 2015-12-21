/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import turbo.POJO.ColorCategory;
import turbo.POJO.ProducerCategory;
import turbo.POJO.Product;
import turbo.POJO.ProductColorDetail;
import turbo.POJO.ProductDetail;

/**
 *
 * @author LeeSan
 */
public class ProductDetailModel implements Serializable{
    private Product product;
    private ProductDetail product_detail;
    private String producer;
    private ArrayList<String> colorDetail = new ArrayList<String>();

    public ArrayList<String> getColorDetail() {
        return colorDetail;
    }

    public void setColorDetail(ArrayList<String> colorDetail) {
        this.colorDetail = colorDetail;
    }
    
    
    

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductDetail getProduct_detail() {
        return product_detail;
    }

    public void setProduct_detail(ProductDetail product_detail) {
        this.product_detail = product_detail;
    }

    /**
     * @return the producer
     */
    public String getProducer() {
        return producer;
    }

    /**
     * @param producer the producer to set
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }
    
            
}
