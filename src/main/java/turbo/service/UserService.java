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
import turbo.model.AccountModel;
import turbo.model.RegiterModel;
import turbo.model.ResetPassModel;
import turbo.model.UpdatePasswordModel;

/**
 *
 * @author LeeSan
 */
public interface UserService {



    String getUserByUsername(String username, String password, String role, AccessTokenModel token);

    String registerUser(RegiterModel user);

    boolean isExistUsername(String username);

    boolean isExistEmail(String email);

    String updateUser(AccountModel account);

    void deleteUser(Long id);

    public String activateUser(String registerToken);

    public String sendResetRequestEmail(String Email, String callbackURL);

    public String updatePassword(UpdatePasswordModel updatePasswordModel, String token);
    public String resetPass(ResetPassModel password, String resetPassToken);
    
    
}
