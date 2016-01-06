/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import turbo.POJO.Account;
import turbo.POJO.Product;
import turbo.model.AccountModel;
import turbo.model.UserBillModel;

/**
 *
 * @author LeeSan
 */
public class RootService<T extends Object> {

    protected AccountModel accountPOJO2Model(Account acc) {
        AccountModel result = new AccountModel();
        result.setAddress(acc.getAddress());
        result.setAvatar(acc.getAvatar());
        if(acc.getBirthday() != null)
            result.setBirthday(acc.getBirthday().getTime());
        else
            result.setBirthday(0);
        result.setFullName(acc.getFullName());
        result.setGender(acc.getGender());
        result.setId(acc.getId());
        result.setVisaCode(acc.getVisaCode());
        
        return result;

    }

    protected int countTotalPage(int total, int limit) {
        int result;

        result = total / limit;
        if (total % limit != 0) {
            result++;
        }

        return result;
    }

    protected ArrayList<T> Paging(ArrayList<T> result, int page, int limit) {
        int size = result.size();
        if (size < page * limit) {
            return result;
        }
        if ((size >= page * limit) && (size < (page + 1) * limit)) {
            return new ArrayList(result.subList(limit * page, size));
        }
        return new ArrayList(result.subList(page * limit, (page + 1) * limit));
    }

}
