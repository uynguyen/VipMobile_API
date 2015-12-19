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

    //Method to read HTML file as a String 
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
        return contents.toString();
    }
    @Override
    public void run() {

        try {
            Session session = createEmailSession();

            // creates a new e-mail message
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(props.getProperty("gmail.username")));
            InternetAddress[] toAddresses = {new InternetAddress(toUser)};
            msg.setRecipients(Message.RecipientType.TO, toAddresses);
            msg.setSubject(props.getProperty("email.subject"));
            msg.setSentDate(new Date());
            String htmlContent = readContentFromFile();
            msg.setContent(htmlContent,
                    "text/html; charset=UTF-8");

            // sends the e-mail
            Transport.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
