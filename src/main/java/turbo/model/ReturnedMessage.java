/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.model;

import java.io.Serializable;
import org.springframework.http.HttpStatus;

/**
 *
 * @author LeeSan
 */
public class ReturnedMessage implements Serializable{
    String mess;

    public ReturnedMessage(String mess) {
        this.mess = mess;
    }

    public ReturnedMessage(){}
    
    
    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
  
    
}
