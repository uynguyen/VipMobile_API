/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import turbo.POJO.Product;
import turbo.POJO.ProductColorDetail;
import turbo.POJO.ProductDetail;
import turbo.model.ProductDetailModel;
import turbo.model.QueryProductStringModel;

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
    public ResponseEntity<List<Product>>
            getProducts(HttpServletRequest request) {
        List<Product> products = new ArrayList<Product>();
        try {

            products = (List<Product>) productService.getProducts();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        ResponseEntity<List<Product>> entity = new ResponseEntity<List<Product>>(products, HttpStatus.OK);
        return entity;
    }

    @RequestMapping(value = {"/{id}"},
            method = {RequestMethod.GET},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public ResponseEntity<ProductDetailModel>
            getProduct(@PathVariable("id") Integer id) {

        ProductDetailModel result = new ProductDetailModel();
        try {
            result = singleProductService.getProductDetail(id);

            ResponseEntity<ProductDetailModel> entity = new ResponseEntity(result, HttpStatus.OK);
            return entity;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            ResponseEntity<ProductDetailModel> entity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            return entity;
        }

    }

    @RequestMapping(value = {"/searchProduct"},
            method = {RequestMethod.POST},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public ResponseEntity<List<Product>>
            searchProduct(@RequestBody QueryProductStringModel model) {

        List<Product> result = new ArrayList<Product>();
        try {
            result = productService.searchProduct(model);
         
            ResponseEntity<List<Product>> entity = new ResponseEntity(result, HttpStatus.OK);
            return entity;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            ResponseEntity<List<Product>> entity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            return entity;
        }

    }

}
