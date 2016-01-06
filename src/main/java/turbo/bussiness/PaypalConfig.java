/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.bussiness;

import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.base.rest.PayPalResource;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 *
 * @author 12125
 */
public class PaypalConfig {
    private static OAuthTokenCredential oauth = null;
    public static void initConfig(){
               
        try {
            Resource resource = new ClassPathResource("/META-INF/sdk_config.properties");
            Properties props = PropertiesLoaderUtils.loadProperties(resource);      
            oauth = PayPalResource.initConfig(props);
  
            System.out.println("Load paypal resource successfullty!");
         
        } catch (IOException ex) {
            Logger.getLogger(PaypalConfig.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public static String getAccessToken (){
        if (oauth != null) {
            try {
                return oauth.getAccessToken();
            } catch (PayPalRESTException ex) {
                Logger.getLogger(PaypalConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
            return "Not config!";
    }

}
