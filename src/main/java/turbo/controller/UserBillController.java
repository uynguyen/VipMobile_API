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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import turbo.POJO.User;
import turbo.POJO.UserBill;
import turbo.model.AccessTokenModel;
import turbo.model.BillDetailModel;
import turbo.model.UserBillModel;
import turbo.service.UserBillService;
import turbo.service.UserService;

/**
 *
 * @author LeeSan
 */
@RestController
@RequestMapping(value = "/bill")
public class UserBillController {

    @Autowired
    private UserBillService userBillService;

    @RequestMapping(value = {"/getUserBills/{page}/{limit}"},
            method = {RequestMethod.GET},
            consumes = {MediaType.ALL_VALUE}
    )
    @ResponseBody
    public ResponseEntity<ArrayList<UserBillModel>>
            getUserBills(@PathVariable("page") int page, @PathVariable("limit") int limit) {
        ArrayList<UserBillModel> result = new ArrayList<>();

        try {

            result = userBillService.getUserBill(page, limit);

            return new ResponseEntity<ArrayList<UserBillModel>>(result, HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<ArrayList<UserBillModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/getBillDetail/{id}"},
            method = {RequestMethod.GET},
            consumes = {MediaType.ALL_VALUE}
    )
    @ResponseBody
    public ResponseEntity<ArrayList<BillDetailModel>>
            getUserBills(@PathVariable("id") int id) {
        ArrayList<BillDetailModel> result = new ArrayList<>();

        try {

            result = userBillService.getBillDetail(id);

            return new ResponseEntity<ArrayList<BillDetailModel>>(result, HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<ArrayList<BillDetailModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
