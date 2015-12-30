/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author LeeSan
 */
public class UserBillModel implements Serializable {

    Integer id;
    String code;

    Date bookDate;
    Double total;
    Double VAT;
    Double sale;
    AccountModel account = new AccountModel();
    BillStateModel state = new BillStateModel();
    ArrayList<BillDetailModel> detail = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getVAT() {
        return VAT;
    }

    public void setVAT(Double VAT) {
        this.VAT = VAT;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }

    public BillStateModel getState() {
        return state;
    }

    public void setState(BillStateModel state) {
        this.state = state;
    }

    public ArrayList<BillDetailModel> getDetail() {
        return detail;
    }

    public void setDetail(ArrayList<BillDetailModel> detail) {
        this.detail = detail;
    }

    

}
