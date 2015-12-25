/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import org.springframework.stereotype.Repository;
import turbo.POJO.BillDetail;
import turbo.POJO.UserBill;

/**
 *
 * @author LeeSan
 */
@Repository
public class HbnUserBillDetailDAO extends AbstractHbnDAO<BillDetail> implements UserBillDetailDAO {

}
