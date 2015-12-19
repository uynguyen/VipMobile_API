/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.List;
import turbo.POJO.Product;
import turbo.POJO.User;
import turbo.model.AccessTokenModel;

/**
 *
 * @author LeeSan
 */
public interface UserService {

    void addNewUSer(User product);

    String getUserByUsername(String username, String password, AccessTokenModel token);

    String registerUser(User user);

    boolean isExistUsername(String username);

    boolean isExistEmail(String email);

    void updateUser(User product);

    void deleteUser(Long id);

    public String activateUser(String registerToken);

    public String sendResetRequestEmail(String Email);
}
