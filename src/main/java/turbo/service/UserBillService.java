/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import turbo.POJO.Arguments;
import turbo.POJO.TransportFee;
import turbo.POJO.User;
import turbo.POJO.UserBill;
import turbo.model.ArrayObjectModel;
import turbo.model.BillDetailModel;
import turbo.model.BillStateCodeModel;
import turbo.model.QueryUserBillModel;
import turbo.model.UpdateUserBillModel;
import turbo.model.UserBillModel;

/**
 *
 * @author LeeSan
 */
public interface UserBillService {

    public ArrayObjectModel getUserBill(int page, int limit);

    public ArrayList<BillDetailModel> getBillDetail(int id);

    public ArrayList<BillStateCodeModel> getBillStateCodes();

    public boolean updateStateUserBill(UpdateUserBillModel model);

    public ArrayObjectModel searchBill(QueryUserBillModel query, int page, int limit);

    public ArrayList<TransportFee> getTransportFee();

    public Arguments getVAT();
    
    public String addNewUserBill(String jsonData, String token, int code);

    public ArrayObjectModel getUserBill(int page, int limit, String token);
    
    public String deleteBill(int idBill);
}
