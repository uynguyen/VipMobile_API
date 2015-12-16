/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.List;
import turbo.POJO.Product;
import turbo.POJO.User;

/**
 *
 * @author LeeSan
 */
public interface UserService {
    void addNewUSer(User product);

    User getUserByUsername(String username, String password);


    void updateUser(User product);

    void deleteUser(Long id);
}
