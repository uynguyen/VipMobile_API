/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import org.springframework.stereotype.Repository;
import turbo.POJO.Account;

/**
 *
 * @author LeeSan
 */
@Repository
public class HbnAccountDAO extends AbstractHbnDAO<Account> implements AccountDAO{
    
}
