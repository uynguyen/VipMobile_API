/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import turbo.POJO.Product;
import turbo.POJO.User;

/**
 *
 * @author LeeSan
 */
public interface UserDAO extends DAO<User> {
    User getUserByUsername(String username);
    User getUserByEmail(String email);
}
