/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.List;
import turbo.POJO.BillDetail;
import turbo.POJO.Product;
import turbo.POJO.UserBill;

/**
 *
 * @author LeeSan
 */
public interface UserBillDetailDAO extends DAO<BillDetail> {

    public List<Product> getBestSaleProducts(int page, int limit);
}
