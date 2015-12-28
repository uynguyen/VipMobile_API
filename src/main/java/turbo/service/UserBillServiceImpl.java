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
import turbo.POJO.Product;
import turbo.POJO.UserBill;
import turbo.model.AccountModel;
import turbo.model.ArrayObjectModel;
import turbo.model.BillDetailModel;
import turbo.model.BillStateCodeModel;
import turbo.model.BillStateModel;
import turbo.model.QueryUserBillModel;
import turbo.model.UpdateUserBillModel;
import turbo.model.UserBillModel;

/**
 *
 * @author LeeSan
 */
@Service("billService")
@Transactional
public class UserBillServiceImpl extends RootService implements UserBillService {

    @Autowired
    private UserBillDAO billDAO;

    @Autowired
    private UserBillDetailDAO billDetailDAO;

    @Autowired
    private BillStateCodeDAO billStateCodeDAO;

    @Override
    public ArrayObjectModel getUserBill(int page, int limit) {
        ArrayObjectModel result = new ArrayObjectModel();
        ArrayList<UserBillModel> array  = new ArrayList<UserBillModel>();
        ArrayList<UserBill> userBillPojo = billDAO.getUserBilḷ̣(page, limit);

        for (UserBill pojo : userBillPojo) {
            UserBillModel item = userBillPOJO2Model(pojo);

            array.add(item);

        }

        result.setTotal(countTotalPage(billDAO.count().intValue(), limit));
        result.setResult(array);
        
        return result;
    }

    private UserBillModel userBillPOJO2Model(UserBill pojo) {
        UserBillModel item = new UserBillModel();

        item.setId(pojo.getId());
        item.setCode(pojo.getCode());
        item.setState(statePOJO2Model(pojo.getState()));
        item.setTotal(pojo.getTotal());
        item.setBookDate(pojo.getBookDate());

        Account acc = pojo.getIdUser().getIdAccount();
        item.setAccount(accountPOJO2Model(acc));

        return item;

    }

    private BillStateModel statePOJO2Model(BillStateCode billState) {
        BillStateModel result = new BillStateModel();

        result.setId(billState.getId());
        result.setValue(billState.getValue());
        result.setDescription(billState.getDescription());

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

    private BillStateCodeModel billStateCodePOJO2Model(BillStateCode billState) {
        BillStateCodeModel result = new BillStateCodeModel();
        result.setId(billState.getId());
        result.setValue(billState.getValue());
        result.setDescription(billState.getDescription());

        return result;

    }

    @Override
    public ArrayList<BillStateCodeModel> getBillStateCodes() {
        ArrayList<BillStateCodeModel> result = new ArrayList<>();

        ArrayList<BillStateCode> billStateCode = (ArrayList<BillStateCode>) billStateCodeDAO.getAll();

        for (BillStateCode item : billStateCode) {
            result.add(billStateCodePOJO2Model(item));
        }

        return result;
    }

    @Override
    public boolean updateStateUserBill(UpdateUserBillModel model) {
        try {
            for (int id : model.getId_bills()) {
                UserBill bill = billDAO.get(id);
                BillStateCode state = billStateCodeDAO.get(model.getId_state());
                bill.setState(null);
                bill.setState(state);
                billDAO.update(bill);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public ArrayObjectModel searchBill(QueryUserBillModel query, int page, int limit) {
        ArrayList<UserBillModel> result = new ArrayList<>();
        ArrayList<UserBill> userbill = new ArrayList<>();
        if (query.getDate_time() != "") {
            userbill = billDAO.getUserBillByDate(query.getDate_time());
        } else {
            userbill = billDAO.getUserBilḷ̣();
        }
        String query_str = query.getQuery_str();
        for (UserBill item : userbill) {
            if (item.getCode().equals(query_str)
                    || item.getIdUser().getIdAccount().getFullName().contains(query_str)
                    || item.getIdUser().getUsername().contains(query_str)
                    || item.getIdUser().getEmail().contains(query_str)) {
                result.add(userBillPOJO2Model(item));
            }
        }

      
        ArrayObjectModel aom = new ArrayObjectModel();      
        aom.setTotal(countTotalPage(result.size(), limit));
        aom.setResult(Paging(result,page,limit));
        
        return aom;
        
    }

//    private ArrayList<UserBillModel> Paging(ArrayList<UserBillModel> result, int page, int limit) {
//        int size = result.size();
//        if (size < page * limit) {
//            return result;
//        }
//        if ((size >= page * limit) && (size < (page + 1) * limit)) {
//            return new ArrayList(result.subList(limit * page, size));
//        }
//        return new ArrayList(result.subList(page * limit, (page + 1) * limit));
//    }
}
