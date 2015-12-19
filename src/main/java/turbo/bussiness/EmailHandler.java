/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.bussiness;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 *
 * @author LeeSan
 */
public abstract class EmailHandler implements Runnable {
  
    protected Properties props;
    protected Thread t;
    protected String contentFile;
    protected String toUser;
    abstract public boolean sendEmail(String email);

    public EmailHandler() {
        Resource resource = new ClassPathResource("/META-INF/EmailHandler.properties");
        try {
            this.props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException ex) {
            Logger.getLogger(RegisterEmailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        t = new Thread(this);
    }

    public Session createEmailSession() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", props.getProperty("mail.smtp.host"));
        properties.put("mail.smtp.port", props.getProperty("mail.smtp.port"));
        properties.put("mail.smtp.auth", props.getProperty("mail.smtp.auth"));
        properties.put("mail.smtp.starttls.enable", props.getProperty("mail.smtp.starttls.enable"));

        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(props.getProperty("gmail.username"),
                        props.getProperty("gmail.password"));
            }
        };

        Session session = Session.getInstance(properties, auth);
        return session;
    }

}
