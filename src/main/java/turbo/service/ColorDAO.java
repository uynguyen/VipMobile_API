/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;


import turbo.POJO.ColorCategory;
import turbo.POJO.ProducerCategory;
import turbo.POJO.ProductColorDetail;

/**
 *
 * @author LeeSan
 */
public interface ColorDAO  extends DAO<ColorCategory>{
    ColorCategory getProductColorDetailByValue(String value);
}
