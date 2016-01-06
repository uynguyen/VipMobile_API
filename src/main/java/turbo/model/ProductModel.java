/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.model;

import java.io.Serializable;
import turbo.POJO.Product;
import turbo.POJO.SaleProduct;

/**
 *
 * @author LeeSan
 */
public class ProductModel implements Serializable{
    private Product product;
    private SaleProduct saleDetail;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SaleProduct getSaleDetail() {
        return saleDetail;
    }

    public void setSaleDetail(SaleProduct saleDetail) {
        this.saleDetail = saleDetail;
    }
    
    
}
