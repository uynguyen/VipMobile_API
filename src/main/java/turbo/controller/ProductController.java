/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import turbo.POJO.Product;
import turbo.POJO.SaleProduct;
import turbo.model.ArrayObjectModel;
import turbo.model.CategoriesModel;
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

    @RequestMapping(value = {"/getCategories"},
            method = {RequestMethod.GET},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public ResponseEntity<CategoriesModel>
            getCategories(HttpServletRequest request) {
        CategoriesModel result = new CategoriesModel();
        try {
            result.setListProducers(productService.getProducerCategory());
            result.setListcolors(productService.getColorCategory());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        ResponseEntity<CategoriesModel> entity = new ResponseEntity<CategoriesModel>(result, HttpStatus.OK);
        return entity;
    }

    @RequestMapping(value = {"/list/{page}/{limit}"},
            method = {RequestMethod.GET},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public ResponseEntity<List<Product>>
            getProducts(@PathVariable("page") int page, @PathVariable("limit") int limit) {
        List<Product> products = new ArrayList<Product>();
        try {
            page -= 1;
            products = (List<Product>) productService.getProducts(page, limit);

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

    @RequestMapping(value = {"/getBestSaleProduct/{page}/{limit}"},
            method = {RequestMethod.GET},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public ResponseEntity<List<Product>>
            getBestSaleProduct(@PathVariable("page") int page, @PathVariable("limit") int limit) {
        List<Product> products = new ArrayList<Product>();
        try {
            page -= 1;
            products = (List<Product>) productService.getNewProduct(page, limit);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        ResponseEntity<List<Product>> entity = new ResponseEntity<List<Product>>(products, HttpStatus.OK);
        return entity;
    }

    @RequestMapping(value = {"/getSaleProduct/{page}/{limit}"},
            method = {RequestMethod.GET},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public ResponseEntity<List<SaleProduct>>
            getSaleProduct(@PathVariable("page") int page, @PathVariable("limit") int limit) {

        List<SaleProduct> result = new ArrayList<SaleProduct>();
        try {
            page -= 1;
            result = productService.getSaleProducts(page, limit);

            ResponseEntity<List<SaleProduct>> entity = new ResponseEntity(result, HttpStatus.OK);
            return entity;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            ResponseEntity<List<SaleProduct>> entity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            return entity;
        }

    }

    @RequestMapping(value = {"/getHighProduct/{limit}"},
            method = {RequestMethod.GET},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public ResponseEntity<List<Product>>
            getHighProduct(@PathVariable("limit") int limit) {

        List<Product> result = new ArrayList<Product>();
        try {

            result = productService.getHighProduct(limit);

            ResponseEntity<List<Product>> entity = new ResponseEntity(result, HttpStatus.OK);
            return entity;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            ResponseEntity<List<Product>> entity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            return entity;
        }

    }

    @RequestMapping(value = {"/searchProduct"},
            method = {RequestMethod.POST},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public ResponseEntity<ArrayObjectModel>
            searchProduct(@RequestBody QueryProductStringModel model) {

        ArrayObjectModel result = new ArrayObjectModel();
        try {
            result = productService.searchProduct(model);

            ResponseEntity<ArrayObjectModel> entity = new ResponseEntity(result, HttpStatus.OK);
            return entity;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            ResponseEntity<ArrayObjectModel> entity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            return entity;
        }

    }

}
