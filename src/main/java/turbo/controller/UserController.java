/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import turbo.POJO.User;
import turbo.model.AccessTokenModel;
import turbo.model.AccountModel;
import turbo.model.RegiterModel;
import turbo.model.RequestResetPassModel;
import turbo.model.ResetPassModel;
import turbo.model.ReturnedMessage;
import turbo.model.UpdatePasswordModel;
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
            userLogin(@RequestBody User user, @RequestParam(value = "Role", required = false) String role) {
        String result = null;

        try {
            AccessTokenModel accessToken = new AccessTokenModel();
            result = userService.getUserByUsername(user.getUsername(), user.getPassword(), role, accessToken);
            accessToken.setMess(result);

            ResponseEntity<AccessTokenModel> entity = new ResponseEntity(accessToken, HttpStatus.OK);
            return entity;

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
    public ResponseEntity<ReturnedMessage>
            registerUser(@RequestBody RegiterModel user) {

        ReturnedMessage result = new ReturnedMessage();
        System.out.println("callback" + user.getCallbackURL());
        try {

            String mess = userService.registerUser(user);
            result.setMess(mess);

            return new ResponseEntity<ReturnedMessage>(result, HttpStatus.CREATED);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<ReturnedMessage>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = {"/activate/{RegisterToken}"},
            method = {RequestMethod.GET},
            produces = {MediaType.ALL_VALUE})

    @ResponseBody
    public ResponseEntity<ReturnedMessage>
            activateUser(@PathVariable("RegisterToken") String registerToken) {

        ReturnedMessage result = new ReturnedMessage();
        try {

            String mess = userService.activateUser(registerToken);
            result.setMess(mess);

            return new ResponseEntity<ReturnedMessage>(result, HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<ReturnedMessage>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = {"/requestResetPass"},
            method = {RequestMethod.POST},
            produces = {MediaType.ALL_VALUE})
    @ResponseBody
    public ResponseEntity<ReturnedMessage>
            requestResetPassword(@RequestBody RequestResetPassModel model) {

        ReturnedMessage result = new ReturnedMessage();
        try {

            String mess = userService.sendResetRequestEmail(model.getEmail(), model.getCallback());
            result.setMess(mess);
            return new ResponseEntity<ReturnedMessage>(result, HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<ReturnedMessage>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   
    @RequestMapping(value = {"/resetPass/{ResetPassToken}"},
            method = {RequestMethod.POST},
            consumes = {MediaType.ALL_VALUE})
    @ResponseBody
    public ResponseEntity<ReturnedMessage>
            resetPassword(@RequestBody ResetPassModel pass, @PathVariable("ResetPassToken") String resetPassToken) {

        ReturnedMessage result = new ReturnedMessage();

        try {

            String str = userService.resetPass(pass, resetPassToken);
            result.setMess(str);
         //   if (str.contains("Reseted")) {
                return new ResponseEntity<ReturnedMessage>(result, HttpStatus.OK);
           // }
           // return new ResponseEntity<ReturnedMessage>(result, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<ReturnedMessage>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/requireToken"},
            method = {RequestMethod.GET},
            produces = {MediaType.ALL_VALUE})
    @ResponseBody
    public ResponseEntity<ReturnedMessage>
            requireToken() {
        System.err.println("requireToken");
        return new ResponseEntity<ReturnedMessage>(new ReturnedMessage("Unauthorized"), HttpStatus.BAD_REQUEST);

    }

    @RequestMapping(value = {"/tokenExpire"},
            method = {RequestMethod.GET},
            produces = {MediaType.ALL_VALUE})
    @ResponseBody
    public ResponseEntity<ReturnedMessage>
            tokenExpire() {
        System.err.println("tokenExpire");
        return new ResponseEntity<ReturnedMessage>(new ReturnedMessage("TokenExpire"), HttpStatus.BAD_REQUEST);

    }

    @RequestMapping(value = {"/updateInfo"},
            method = {RequestMethod.POST},
            produces = {MediaType.ALL_VALUE})
    @ResponseBody
    public ResponseEntity<ReturnedMessage>
            updateInfo(@RequestBody AccountModel account) {

        ReturnedMessage result = new ReturnedMessage();
        try {

            String mess = userService.updateUser(account);
            result.setMess(mess);
            return new ResponseEntity<ReturnedMessage>(result, HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<ReturnedMessage>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/updatePassword"},
            method = {RequestMethod.POST},
            produces = {MediaType.ALL_VALUE})
    @ResponseBody
    public ResponseEntity<ReturnedMessage>
            updatePassword(@RequestBody UpdatePasswordModel updatePasswordModel, HttpServletRequest request) {

        ReturnedMessage result = new ReturnedMessage();
        try {
            String token = (String) request.getAttribute("token");
            String mess = userService.updatePassword(updatePasswordModel, token);
            result.setMess(mess);
         //   if(mess.contains("Updated"))
                return new ResponseEntity<ReturnedMessage>(result, HttpStatus.OK);
  
          //  return new ResponseEntity<ReturnedMessage>(result, HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<ReturnedMessage>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
