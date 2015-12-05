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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import turbo.POJO.Product;

import turbo.service.ProductService;

/**
 *
 * @author LeeSan
 */
@RestController
@RequestMapping(value = "/book")
public class ProductController {

    @Autowired
    private ProductService productService;

    private static ArrayList<String> books = new ArrayList<String>();

    @RequestMapping(value = {"/list"},
            method = {RequestMethod.GET},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public ResponseEntity<String>
            getBooks() {

        try {

            //books = (ArrayList<Product>) productService.getProducts();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        books.add("Uy Nguyen");
        books.add("Uy Nguyen 2");
        ResponseEntity<String> entity = new ResponseEntity(books, HttpStatus.OK);
        return entity;
    }
}
