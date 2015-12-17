/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.controller;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import turbo.POJO.Product;
import turbo.common.AccessToken;

/**
 *
 * @author LeeSan
 */
@RestController
@RequestMapping("/oauth")
public class Oauth2Controller {

    @RequestMapping(value = {"/getAccessToken"},
            method = {RequestMethod.GET},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public ResponseEntity<AccessToken>
            getProducts() throws NoSuchAlgorithmException {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        AccessToken test = new AccessToken();
        test.setAccess_token(randomUUIDString);
        test.setExprire(60);
        
        ResponseEntity<AccessToken> entity = new ResponseEntity(test, HttpStatus.OK);
        return entity;
    }

}
