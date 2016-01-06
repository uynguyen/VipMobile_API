/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import turbo.POJO.ProducerCategory;
import turbo.POJO.Product;
import turbo.POJO.ProductDetail;

/**
 *
 * @author LeeSan
 */
public interface ProducerDAO extends DAO<ProducerCategory>{
    ProducerCategory getProducerCategoryByValue(String value);
}
