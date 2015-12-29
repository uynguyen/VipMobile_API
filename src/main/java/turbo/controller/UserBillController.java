/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.controller;

import java.util.ArrayList;
import javax.json.JsonObject;
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
import turbo.model.ArrayObjectModel;
import turbo.model.BillDetailModel;
import turbo.model.BillStateCodeModel;
import turbo.model.QueryUserBillModel;
import turbo.model.ReturnedMessage;
import turbo.model.UpdateUserBillModel;
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

    @RequestMapping(value = {"/getBillState"},
            method = {RequestMethod.GET},
            consumes = {MediaType.ALL_VALUE}
    )
    @ResponseBody
    public ResponseEntity<ArrayList<BillStateCodeModel>>
            getUserBills() {
        ArrayList<BillStateCodeModel> result = new ArrayList<>();

        try {

            result = userBillService.getBillStateCodes();

            return new ResponseEntity<ArrayList<BillStateCodeModel>>(result, HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<ArrayList<BillStateCodeModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/getUserBills/{page}/{limit}"},
            method = {RequestMethod.GET},
            consumes = {MediaType.ALL_VALUE}
    )
    @ResponseBody
    public ResponseEntity<ArrayObjectModel>
            getUserBills(@PathVariable("page") int page, @PathVariable("limit") int limit) {
        ArrayObjectModel result = new ArrayObjectModel();

        try {

            result = userBillService.getUserBill(page, limit);

            return new ResponseEntity<ArrayObjectModel>(result, HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<ArrayObjectModel>(HttpStatus.INTERNAL_SERVER_ERROR);
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

    @RequestMapping(value = {"/updateBillState"},
            method = {RequestMethod.POST},
            consumes = {MediaType.ALL_VALUE}
    )
    @ResponseBody
    public ResponseEntity<ReturnedMessage>
            getUserBills(@RequestBody UpdateUserBillModel model) {
        ReturnedMessage result = new ReturnedMessage();
        try {

            if (userBillService.updateStateUserBill(model)) {
                result.setMess("Sucess");
                return new ResponseEntity<ReturnedMessage>(result, HttpStatus.OK);
            }
            result.setMess("Fail");
            return new ResponseEntity<ReturnedMessage>(result, HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<ReturnedMessage>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/searchBills/{page}/{limit}"},
            method = {RequestMethod.POST},
            consumes = {MediaType.ALL_VALUE}
    )
    @ResponseBody
    public ResponseEntity<ArrayObjectModel>
            searchUserBills(@RequestBody QueryUserBillModel query, @PathVariable("page") int page,
                    @PathVariable("limit") int limit) {
        ArrayObjectModel result = new ArrayObjectModel();

        try {

            result = userBillService.searchBill(query, page, limit);

            return new ResponseEntity<ArrayObjectModel>(result, HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<ArrayObjectModel>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}