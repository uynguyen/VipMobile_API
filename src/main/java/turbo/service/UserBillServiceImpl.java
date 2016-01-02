/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.transaction.Transactional;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import turbo.POJO.AccessToken;
import turbo.POJO.Account;
import turbo.POJO.Arguments;
import turbo.POJO.BillDetail;
import turbo.POJO.BillStateCode;
import turbo.POJO.Product;
import turbo.POJO.TransportFee;
import turbo.POJO.User;
import turbo.POJO.UserBill;
import turbo.bussiness.UserBillEmailHandler;
import turbo.bussiness.EmailHandler;
import turbo.common.AppArguments;
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
    private ProductDAO productDAO;

    @Autowired
    private UserBillDAO billDAO;

    @Autowired
    private UserBillDetailDAO billDetailDAO;

    @Autowired
    private BillStateCodeDAO billStateCodeDAO;

    @Autowired
    private TransportFeeDAO transportFeeDAO;

    @Autowired
    private AccessTokenDAO accessTokenDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ArgumentsDAO argumentsDAO;

    @Override
    public ArrayObjectModel getUserBill(int page, int limit) {
        ArrayObjectModel result = new ArrayObjectModel();
        ArrayList<UserBillModel> array = new ArrayList<UserBillModel>();
        ArrayList<UserBill> userBillPojo = billDAO.getUserBilḷ̣(page, limit);

        for (UserBill pojo : userBillPojo) {
            UserBillModel item = userBillPOJO2Model(pojo, false);

            array.add(item);

        }

        result.setTotal(countTotalPage(billDAO.count().intValue(), limit));
        result.setResult(array);

        return result;
    }

    private UserBillModel userBillPOJO2Model(UserBill pojo, boolean isAdmin) {
        UserBillModel item = new UserBillModel();

        item.setId(pojo.getId());
        item.setCode(pojo.getCode());
        item.setState(statePOJO2Model(pojo.getState()));
        item.setTotal(pojo.getTotal());
        item.setBookDate(pojo.getBookDate());
        item.setTransport_fee(pojo.getStranportFee());
        item.setVAT(pojo.getVat());
        if (isAdmin) {
            Account acc = pojo.getIdUser().getIdAccount();
            item.setAccount(accountPOJO2Model(acc));

        } else {
            ArrayList<BillDetailModel> detail = getBillDetail(pojo.getId());

            item.setDetail(detail);

        }

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
                    itemModel.setName(item.getIdProduct().getName());
                    itemModel.setPrice(item.getIdProduct().getPrice());
                    itemModel.setCode(item.getIdProduct().getCode());
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
                // bill.setState(null);
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
                result.add(userBillPOJO2Model(item, true));
            }
        }

        ArrayObjectModel aom = new ArrayObjectModel();
        aom.setTotal(countTotalPage(result.size(), limit));
        aom.setResult(Paging(result, page, limit));

        return aom;

    }

    @Override
    public ArrayList<TransportFee> getTransportFee() {
        return (ArrayList<TransportFee>) transportFeeDAO.getAll();
    }

    //TODO: Send email to user to accounce
    @Override
    public String addNewUserBill(String jsonData, String token) {
        try {
            JSONObject object = new JSONObject(jsonData);
            UserBill bill = new UserBill();

            AccessToken accessToken = accessTokenDAO.getAccessToken(token);
            User user = accessToken.getUserId();
            bill.setCode(generateBillCode(user.getUsername(), new Date()));
            bill.setTotal(calculateBillTotal(object));
            JSONObject infoObject = object.getJSONObject("info");
            JSONObject transportFee = infoObject.getJSONObject("fee");
            String address = infoObject.getString("address") + ", " + transportFee.getString("area")
                    + ", " + infoObject.getString("city");
            bill.setAddress(address);
            bill.setBookDate(new Date());
            bill.setStranportFee(transportFee.getDouble("fee"));
            bill.setVat(object.getDouble("VAT"));
            bill.setPhone(infoObject.getString("phone"));
            bill.setIdUser(user);

            BillStateCode state = billStateCodeDAO.get(2);
            bill.setState(state);
            JSONObject cart = object.getJSONObject("cart");

            bill = billDAO.create(bill);
            if (bill != null) {
                ArrayList<BillDetail> lst = convertObjectJSONToList(cart, bill);
                if (lst != null) {
                    UserBillModel model = userBillPOJO2Model(bill, false);
                    EmailHandler emailHandler = new UserBillEmailHandler(user.getUsername(), model, true);
                    emailHandler.sendEmail(user.getEmail());
                    System.out.println("INSERT SUCCESSED " + lst.size());
                    return "Success";

                } else // Remove user bill cause error occur
                {
                    System.out.println("Remove user bill cause error occur ");
                    billDAO.delete(bill);
                }

            }

            return "Error";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error" + e.getMessage();
        }

    }

    private String generateBillCode(String fullName, Date date) {
        String result = "";

        SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSSSddMMyyyy");
        String temp = sdf.format(date);
        result = fullName.toUpperCase() + temp;
        return result;
    }

    private String randomChars() {
        char[] chars = "abcdefghij".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    private ArrayList<BillDetail> convertObjectJSONToList(JSONObject cart, UserBill bill) {
        try {
            ArrayList<BillDetail> result = new ArrayList<>();

            for (String key : cart.keySet()) {
                JSONObject productItem = cart.getJSONObject(key);
                BillDetail billDetailItem = new BillDetail();
                int quantity = productItem.getInt("quantity");
                JSONObject product = productItem.getJSONObject("product");

                Product p = productDAO.get(product.getInt("id"));
                if (p != null) {
                    billDetailItem.setAmount(quantity);
                    billDetailItem.setIdProduct(p);

                    double total = quantity * p.getPrice();
                    billDetailItem.setTotalPrice(total);
                    billDetailItem.setIdBill(bill);
                    billDetailItem = billDetailDAO.create(billDetailItem);
                    if (billDetailItem != null) {
                        result.add(billDetailItem);

                    } else { //Has error : Cannot insert userbill
                        return null;
                    }
                } else { // Has error: Not exist the product
                    return null;
                }

            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private void sortUserBill(ArrayList<UserBillModel> lst) {
        Collections.sort(lst, new Comparator<UserBillModel>() {
            @Override
            public int compare(UserBillModel p1, UserBillModel p2) {

                return p2.getBookDate().compareTo(p1.getBookDate());
            }
        });
    }

    @Override
    public ArrayObjectModel getUserBill(int page, int limit, String token) {

        ArrayObjectModel result = new ArrayObjectModel();
        User user = accessTokenDAO.getAccessToken(token).getUserId();

        ArrayList<UserBillModel> array = new ArrayList<UserBillModel>();

        User realUser = userDAO.get(user.getId());
        Collection<UserBill> userBillPojo = realUser.getUserBillCollection();

        for (int i = 0; i < userBillPojo.size(); i++) {
            UserBill pojo = (UserBill) userBillPojo.toArray()[i];
            UserBillModel item = userBillPOJO2Model(pojo, false);

            array.add(item);

        }
        sortUserBill(array);
        result.setTotal(countTotalPage(array.size(), limit));
        result.setResult(Paging(array, page, limit));

        return result;
    }

    @Override
    public String deleteBill(int idBill) {
        try {
            String result = "";
            AppArguments aa = new AppArguments();
            UserBill userbill = billDAO.get(idBill);
            Date bookDate = userbill.getBookDate();
            Date currentDate = new Date();
            long distance = currentDate.getTime() - bookDate.getTime();
            long hours = TimeUnit.MILLISECONDS.toHours(distance);
            int consant_time = Integer.parseInt(aa.getProps().get("timeLimitToDeleteBill").toString());
            if (hours <= consant_time) { //Expire

                //  Collection<BillDetail> detail = userbill.getBillDetailCollection();
                userbill.setState(billStateCodeDAO.get(5));

                billDAO.update(userbill);

                EmailHandler emailHandler = new UserBillEmailHandler(userbill.getIdUser().getUsername(), userBillPOJO2Model(userbill, false), false);
                emailHandler.sendEmail(userbill.getIdUser().getEmail());
                return "Deleted";

            } else {
                result = "Time Expire";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error " + e.getMessage();
        }

    }

    @Override
    public Arguments getVAT() {
        Arguments ar = argumentsDAO.getArgumentByName("VAT");
        return ar;
    }

    private Double calculateBillTotal(JSONObject object) {
        double result = 0;
        try {
            JSONObject cart = object.getJSONObject("cart");

            for (String key : cart.keySet()) {
                JSONObject productItem = cart.getJSONObject(key);

                int quantity = productItem.getInt("quantity");
                JSONObject product = productItem.getJSONObject("product");
                double price = product.getDouble("price");
                result += quantity * price;

            }
            double vat = Double.parseDouble(getVAT().getValue());
            
            //result += vat * result;
            result += vat;
            result += object.getJSONObject("info").getJSONObject("fee").getDouble("fee");
            System.out.println("TOTAL" + vat);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0d;
        }
    }
}
