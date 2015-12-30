/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.bussiness;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author LeeSan
 */
@Component
public class RegisterEmailHandler extends EmailHandler {

    private String callbackURL;
    private String name;
    public RegisterEmailHandler(String callback, String name) {
        super();
        this.callbackURL = callback;
        this.name = name;
        contentFile = "/META-INF/RegisterContent.html";
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
        result = result.replace("[REGISTERLINK]", callbackURL).replace("[NAME]", name);
        Date now = new Date();
        result += now.toLocaleString();
        return result;
    }
}
