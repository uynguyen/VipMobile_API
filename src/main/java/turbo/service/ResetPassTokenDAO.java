/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import turbo.POJO.RegisterToken;
import turbo.POJO.ResetpassToken;

/**
 *
 * @author LeeSan
 */
public interface ResetPassTokenDAO extends DAO<ResetpassToken>{
     ResetpassToken getResetpassToken(String token);
}
