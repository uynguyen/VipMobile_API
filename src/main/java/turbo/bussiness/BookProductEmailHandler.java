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
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Locale;
import turbo.model.BillDetailModel;
import turbo.model.UserBillModel;

/**
 *
 * @author LeeSan
 */
public class BookProductEmailHandler extends EmailHandler {

    private String name;
    private UserBillModel bill;

    public BookProductEmailHandler(String name, UserBillModel bill) {
        super();
        this.bill = bill;
        this.name = name;
        contentFile = "/META-INF/BookProductContent.html";
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
        result = result.replace("[NAME]", name).replace("[DETAIL]", generateContent());
        Date now = new Date();
        result += now.toLocaleString();
        return result;
    }

    private String generateContent() {
        String result = "";
        System.out.println(bill.getTotal());
        String total = String.format("%,d", Integer.parseInt(String.format("%.0f", bill.getTotal())));

        result += "<h4>Mã hóa đơn: " + bill.getCode() + "</h4>";
        result += "<h4>Ngày đặt hàng: " + bill.getBookDate().toLocaleString() + "</h4>";
        result += "<h4>Tình trạng: " + bill.getState().getValue() + "</h4>";
        result += "<h4>Thuế: " + bill.getVAT() + " %</h4>";
        result += "<h4>Chi phí vận chuyển: " + String.format("%,d", Integer.parseInt(String.format("%.0f", bill.getTransport_fee()))) + "VND</h4>";
        result += "<h4>Tổng cộng: " + total + "</h4>";

        result += "<br />";
        result += "<table width='891' border='1' align='center'>\n"
                + "  <tr align='center'>\n"
                + "    <th width='43' scope='row'> STT </th>\n"
                + "    <th width='112'> Mã sản phẩm </th>\n"
                + "    <th width='121'> Tên sản phẩm </th>\n"
                + "    <th width='89'> Giá </th>\n"
                + "    <th width='181'> Số lượng </th>\n"
                + "    <th width='141'>Thành tiền</th>\n"
                + "  </tr>\n";
        int i = 1;
        for (BillDetailModel p : bill.getDetail()) {

            result += ("  <tr>");
            result += ("    <td scope='row'>" + i + "</td>");
            result += ("    <td>" + p.getCode() + "</td>");
            result += ("    <td>" + p.getName() + "</td>");
            result += ("    <td>" + String.format("%,d", Integer.parseInt(String.format("%.0f", p.getPrice()))) + "</td>");
            result += ("    <td>" + p.getAmount() + "</td>");
            result += ("    <td>" + String.format("%,d", Integer.parseInt(String.format("%.0f", p.getTotal_price()))) + "</td>");
            result += ("  </tr>");
            i++;
        }
        result += "  <tr>\n"
                + "    <th height='39' colspan='5' scope='row'>Tổng cộng</th>\n"
                + "    <td>" + total + " VND</td>\n"
                + "  </tr>\n"
                + "</table>";

        return result;
    }
}
