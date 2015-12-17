/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.bussiness;

import java.io.IOException;
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
public class EmailHandlerBus implements Runnable {

    private Properties props;
    private Thread t;

    public EmailHandlerBus() {
        Resource resource = new ClassPathResource("/META-INF/EmailHandler.properties");
        try {
            this.props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException ex) {
            Logger.getLogger(EmailHandlerBus.class.getName()).log(Level.SEVERE, null, ex);
        }
        t = new Thread(this);
        t.start();
    }

    public boolean sendEmail() {
        try {

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

            // creates a new e-mail message
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(props.getProperty("gmail.username")));
            InternetAddress[] toAddresses = {new InternetAddress("uynguyen.itus@gmail.com")};
            msg.setRecipients(Message.RecipientType.TO, toAddresses);
            msg.setSubject(props.getProperty("email.subject"));
            msg.setSentDate(new Date());

            String htmlContent = "<h3>Quý khách vừa thực hiện đặt hàng với TURBO MOBILE </h3>\n"
                    + "<h3>Dưới đây là chi tiết hóa đơn: </h3>\n"
                    + "<table width='891' border='1' align='center'>\n"
                    + "  <tr align='center'>\n"
                    + "    <th width='43' scope='row'><strong>STT</strong></th>\n"
                    + "    <td width='112'><strong>Mã sản phẩm</strong></td>\n"
                    + "    <td width='121'><strong>Tên sản phẩm</strong></td>\n"
                    + "    <td width='89'><strong>Kích thước màn hình</strong></td>\n"
                    + "    <td width='70'><strong>Màu</strong></td>\n"
                    + "    <td width='181'><strong>Số lượng</strong></td>\n"
                    + "    <td width='102'><strong>Đơn giá</strong></td>\n"
                    + "    <td width='141'>Thành tiền</td>\n"
                    + "  </tr>\n"
                    + "  <tr>\n";

            htmlContent += "  <tr>\n"
                    + "    <th height='39' colspan='7' scope='row'>Tổng cộng</th>\n"
                    + "    <td>VND</td>\n"
                    + "  </tr>\n"
                    + "</table>"
                    + "<h3>Cảm ơn quý khách đã sử dụng dịch vụ của chúng tôi !!!</h3>\n";
            msg.setContent(htmlContent,
                    "text/html; charset=UTF-8");

            // sends the e-mail
            Transport.send(msg);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void run() {
        sendEmail();
    }
}
