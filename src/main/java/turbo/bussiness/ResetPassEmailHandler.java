/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.bussiness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

/**
 *
 * @author LeeSan
 */
public class ResetPassEmailHandler extends EmailHandler {

    String callbackURL;
    String name;

    public ResetPassEmailHandler(String callbackURL, String name) {
        super();
        contentFile = "/META-INF/ResetPassContent.html";
        this.callbackURL = callbackURL;
        this.name = name;
    }

    @Override
    public String readContentFromFile() {
        StringBuffer contents = new StringBuffer();

        try {
            //use buffering, reading one line at a time
            InputStream ip = getClass().getClassLoader().getResourceAsStream(contentFile);

            BufferedReader reader = new BufferedReader(new InputStreamReader(ip, "UTF-8"));
            try {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    contents.append(line);
                    contents.append(System.getProperty("line.separator"));
                }
            } finally {
                reader.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String result = contents.toString();
        result = result.replace("[RESETPASSLINK]", callbackURL).replace("[NAME]", name);
        Date now = new Date();
        result += now.toLocaleString();
        return result;
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
