/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.controller;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LeeSan
 */
@RestController
@RequestMapping(value = "/book")
public class ProductController {

    private static ArrayList<String> books = new ArrayList<String>();

    static {

        books.add("Java 1");
        books.add("Java 2");
        books.add("Java 3");

    }

    @RequestMapping(value = {"/list"},
            method = {RequestMethod.GET},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public ResponseEntity<String>
            getBooks() {

        ResponseEntity<String> entity = new ResponseEntity(books, HttpStatus.OK);
        return entity;
    }
}
