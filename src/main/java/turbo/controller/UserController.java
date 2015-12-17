/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import turbo.POJO.Product;
import turbo.POJO.TEST;
import turbo.POJO.User;
import turbo.service.ProductService;
import turbo.service.UserService;

/**
 *
 * @author LeeSan
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

           
    @RequestMapping(value = {"/login"},
            method = {RequestMethod.POST}
            ,
            consumes = {MediaType.ALL_VALUE}
    )
    @ResponseBody
    public ResponseEntity<User>
            getProduct(@RequestBody User user) {
        User result = null;
        String username = "";
        String password = "";
        try {

            result = (User) userService.getUserByUsername(username, password);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        ResponseEntity<User> entity = new ResponseEntity(result, HttpStatus.OK);
        return entity;
    }
}
