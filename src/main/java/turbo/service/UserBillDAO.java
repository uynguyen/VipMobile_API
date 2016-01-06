/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import java.util.Date;
import turbo.POJO.Product;
import turbo.POJO.UserBill;

/**
 *
 * @author LeeSan
 */
public interface UserBillDAO extends DAO<UserBill> {

    ArrayList<UserBill> getUserBilḷ̣(Integer page, Integer limit);

    ArrayList<UserBill> getUserBillByUsernamẹ(String username);

    ArrayList<UserBill> getUserBillByCode(String billCode);

    ArrayList<UserBill> getUserBillByDate(String bookDate);

    ArrayList<UserBill> getUserBilḷ̣ByIdUser(Integer page, Integer limit, Integer idUser);

    public ArrayList<UserBill> getUserBilḷ̣();
}
