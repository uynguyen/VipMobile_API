/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author LeeSan
 */
public class AccessTokenModel implements Serializable{

    String mess;
    String token;
    Date expireDate;

    AccountModel acc = new AccountModel();

    public AccountModel getAcc() {
        return acc;
    }

    public void setAcc(AccountModel acc) {
        this.acc = acc;
    }
    
    
    
    
    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
    
    
    
}
