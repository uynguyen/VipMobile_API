/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import java.util.Collection;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import turbo.POJO.Account;
import turbo.POJO.BillDetail;
import turbo.POJO.BillStateCode;
import turbo.POJO.UserBill;
import turbo.model.AccountModel;
import turbo.model.BillDetailModel;
import turbo.model.BillStateModel;
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

    @Autowired
    private UserBillDetailDAO billDetailDAO;

    @Override
    public ArrayList<UserBillModel> getUserBill(int page, int limit) {
        ArrayList<UserBillModel> result = new ArrayList<UserBillModel>();
        ArrayList<UserBill> userBillPojo = billDAO.getUserBilḷ̣(page, limit);

        for (UserBill pojo : userBillPojo) {
            UserBillModel item = new UserBillModel();

            item.setId(pojo.getId());
            item.setCode(pojo.getCode());
            item.setState(statePOJO2Model(pojo.getState()));
            item.setTotal(pojo.getTotal());
            item.setBookDate(pojo.getBookDate());

            Account acc = pojo.getIdUser().getIdAccount();
            item.setAccount(accountPOJO2Model(acc));
            result.add(item);

        }

        return result;
    }

    private BillStateModel statePOJO2Model(BillStateCode billState) {
        BillStateModel result = new BillStateModel();

        result.setId(billState.getId());
        result.setValue(billState.getValue());
        result.setValue(billState.getDescription());

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

    @Override
    public ArrayList<BillDetailModel> getBillDetail(int id) {
        ArrayList<BillDetailModel> result = new ArrayList<>();

        UserBill billDetail = billDAO.get(id);
        if (billDetail != null) {
            Collection<BillDetail> details = billDetail.getBillDetailCollection();
            if (details != null) {
                for (int i = 0; i < details.size(); i++) {
                    BillDetail item = (BillDetail) details.toArray()[i];
                    BillDetailModel itemModel = new BillDetailModel();

                    itemModel.setId_product(item.getIdProduct().getId());
                    itemModel.setAmount(item.getAmount());
                    itemModel.setTotal_price(item.getTotalPrice());
                    itemModel.setProduct_image(item.getIdProduct().getImage());
                    result.add(itemModel);
                }
            }
        }

        return result;
    }
}
