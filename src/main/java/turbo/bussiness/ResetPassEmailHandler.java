/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.bussiness;

/**
 *
 * @author LeeSan
 */
public class ResetPassEmailHandler extends EmailHandler {

    public ResetPassEmailHandler() {
        super();
        contentFile = "/META-INF/ResetPassContent.html";
    }

    @Override
    public boolean sendEmail(String email) {
        try {
            toUser = email;
            t.start();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
