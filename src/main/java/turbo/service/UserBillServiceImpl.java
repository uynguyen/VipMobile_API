/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import turbo.POJO.Account;
import turbo.POJO.UserBill;
import turbo.model.AccountModel;
import turbo.model.UserBillModel;

/**
 *
 * @author LeeSan
 */
@Service("billService")
@Transactional
public class UserBillServiceImpl implements UserBillService {

    @Autowired
    private UserBillDAO billDAO;

    @Override
    public ArrayList<UserBillModel> getUserBill(int page, int limit) {
        ArrayList<UserBillModel> result = new ArrayList<UserBillModel>();
        ArrayList<UserBill> userBillPojo = billDAO.getUserBilḷ̣(page, limit);

        for (UserBill pojo : userBillPojo) {
            UserBillModel item = new UserBillModel();

            item.setId(pojo.getId());
            item.setCode(pojo.getCode());
            item.setState(pojo.getState());
            item.setTotal(pojo.getTotal());
            item.setBookDate(pojo.getBookDate());

            Account acc = pojo.getIdUser().getIdAccount();
            item.setAccount(accountPOJO2Model(acc));
            result.add(item);

        }

        return result;
    }

    private AccountModel accountPOJO2Model(Account acc) {
        AccountModel result = new AccountModel();
        result.setAddress(acc.getAddress());
        result.setAvata(acc.getAvatar());
        result.setBirhDate(acc.getBirthday());
        result.setFullname(acc.getFullName());
        result.setGender(acc.getGender());
        result.setId(acc.getId());
        result.setVisaCode(acc.getVisaCode());

        return result;

    }
}
