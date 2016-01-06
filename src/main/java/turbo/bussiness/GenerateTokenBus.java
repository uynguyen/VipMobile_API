/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.bussiness;

import java.util.Calendar;
import java.util.Date;
import turbo.model.AccessTokenModel;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author LeeSan
 */
public class GenerateTokenBus {

    static int expire_minute = 60;

    public static AccessTokenModel generateToken(String keysource) {
        AccessTokenModel result = new AccessTokenModel();

        Calendar cal = Calendar.getInstance();
        //now.setMinutes(now.getMinutes() + expire_minute);
        result.setExpireDate(new Date(cal.getTimeInMillis() + expire_minute * 60000));
        String keySource = keysource + cal.getTimeInMillis() + "1212505-1212513";

        byte[] tokenByte = new Base64().encode(keySource.getBytes());
        String token = new String(tokenByte);
        result.setToken(token);
        return result;
    }
}
