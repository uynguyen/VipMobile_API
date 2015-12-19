/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
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
import turbo.POJO.User;
import turbo.bussiness.EmailHandler;
import turbo.bussiness.RegisterEmailHandler;
import turbo.model.AccessTokenModel;
import turbo.model.ResetPassModel;
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
            method = {RequestMethod.POST},
            consumes = {MediaType.ALL_VALUE}
    )
    @ResponseBody
    public ResponseEntity<AccessTokenModel>
            userLogin(@RequestBody User user) {
        String result = null;

        try {
            AccessTokenModel accessToken = null;
            result = userService.getUserByUsername(user.getUsername(), user.getPassword(), accessToken);
            if (accessToken != null) {
                ResponseEntity<AccessTokenModel> entity = new ResponseEntity(accessToken, HttpStatus.OK);
                return entity;
            }

            return new ResponseEntity<AccessTokenModel>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<AccessTokenModel>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/register"},
            method = {RequestMethod.POST},
            consumes = {MediaType.ALL_VALUE}
    )
    @ResponseBody
    public ResponseEntity<String>
            registerUser(@RequestBody User user) {

        String result = "";
        try {

            result = userService.registerUser(user);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        if (result.contains("CreateSuccess")) {
            return new ResponseEntity<String>(result, HttpStatus.CREATED);
        }

        return new ResponseEntity<String>(result, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = {"/activate/{RegisterToken}"},
            method = {RequestMethod.GET},
            produces = {MediaType.ALL_VALUE})

    @ResponseBody
    public ResponseEntity<String>
            activateUser(@PathVariable("RegisterToken") String registerToken) {

        String result = "";
        try {

            result = userService.activateUser(registerToken);
            if (result.contains("activated")) {

                return new ResponseEntity<String>(result, HttpStatus.OK);
            } else {

                return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = {"/requestResetPass/{Email}"},
            method = {RequestMethod.GET},
            produces = {MediaType.ALL_VALUE})
    @ResponseBody
    public ResponseEntity<String>
            requestResetPassword(@PathVariable("Email") String Email) {

        String result = "";
        try {

            result = userService.sendResetRequestEmail(Email);

            return new ResponseEntity<String>(result, HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/resetPass"},
            method = {RequestMethod.POST},
            consumes = {MediaType.ALL_VALUE})
    @ResponseBody
    public ResponseEntity<String>
            resetPassword(@RequestBody ResetPassModel pass) {

        String result = "";
        try {

            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/requireToken"},
            method = {RequestMethod.GET},
            produces = {MediaType.ALL_VALUE})
    @ResponseBody
    public ResponseEntity<String>
            requireToken() {

        return new ResponseEntity<String>("Unauthorized", HttpStatus.BAD_REQUEST);

    }
}
