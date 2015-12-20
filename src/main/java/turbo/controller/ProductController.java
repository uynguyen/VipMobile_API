/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import turbo.POJO.Product;
import turbo.POJO.ProductDetail;

import turbo.service.ProductService;
import turbo.service.SingleProductService;

/**
 *
 * @author LeeSan
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SingleProductService singleProductService;

    @RequestMapping(value = {"/list"},
            method = {RequestMethod.GET},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public ResponseEntity<Product>
            getProducts() {
        ArrayList<Product> products = new ArrayList<Product>();
        try {

            products = (ArrayList<Product>) productService.getProducts();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        ResponseEntity<Product> entity = new ResponseEntity(products, HttpStatus.OK);
        return entity;
    }

    @RequestMapping(value = {"/{id}"},
            method = {RequestMethod.GET},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public ResponseEntity<ProductDetail>
            getProduct(@PathVariable("id") Integer id) {
        ProductDetail result = null;
        try {

            result =  singleProductService.getProductDetail(id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        ResponseEntity<ProductDetail> entity = new ResponseEntity(result, HttpStatus.OK);
        return entity;
    }

}
