/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import turbo.POJO.Product;
import turbo.POJO.UserBill;

/**
 *
 * @author LeeSan
 */
public interface UserBillDAO extends DAO<UserBill> {
    ArrayList<UserBill> getUserBilḷ̣(int page, int limit);
    ArrayList<UserBill> getUserBillByUsernamẹ(String username);
    ArrayList<UserBill> getUserBillByCode(String billCode);
    ArrayList<UserBill> getUserBillByDate(String bookDate);
}
