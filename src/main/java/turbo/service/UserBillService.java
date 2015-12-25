/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import turbo.POJO.User;
import turbo.POJO.UserBill;
import turbo.model.BillDetailModel;
import turbo.model.UserBillModel;

/**
 *
 * @author LeeSan
 */
public interface UserBillService {
    ArrayList<UserBillModel> getUserBill(int page, int limit);
    
    ArrayList<BillDetailModel> getBillDetail(int id);
    
}
