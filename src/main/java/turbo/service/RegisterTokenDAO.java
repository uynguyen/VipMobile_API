/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import turbo.POJO.RegisterToken;

/**
 *
 * @author LeeSan
 */
public interface RegisterTokenDAO extends DAO<RegisterToken> {
    RegisterToken getRegisterToken(String token);
}
