/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author 12125
 */
@Service
public class Report {  
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private ServletContext servletContext;
    
    public void saveReportToPdf(String srcFile, String destFile, HashMap params) 
            throws JRException, SQLException, IOException{       
        Connection con = dataSource.getConnection();
        JasperPrint printer = JasperFillManager.fillReport(srcFile, params, con);
        JasperExportManager.exportReportToPdfFile(printer, destFile);   
        con.close();
    }
    
     public void saveReportToXls(String srcFile, String destFile, HashMap params) 
            throws JRException, SQLException, IOException{   
         Connection con = dataSource.getConnection();
        JasperPrint printer = JasperFillManager.fillReport(srcFile, params, con);
        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, printer);
            exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME,
                  srcFile);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
                  destFile);
            exporter.exportReport();  
            con.close();
    }
     
     public void saveReportToHtml(String srcFile, String destFile, HashMap params) 
            throws JRException, SQLException, IOException{   
         Connection con = dataSource.getConnection();
        JasperPrint printer = JasperFillManager.fillReport(srcFile, params, con);
        JasperExportManager.exportReportToHtmlFile(printer, destFile);
        con.close();
    }
       
     
    
    public String generateIncomeReport(String type) {
        String result = "success";

        Resource resource = new ClassPathResource("/META-INF/" + "income_" + type + ".jasper");
        String resourcePath = servletContext.getRealPath("/Resources");
        File filePdf = new File(resourcePath + "/reports/pdf");
        File fileHtml = new File(resourcePath + "/reports/html");
        File fileXls = new File(resourcePath + "/reports/xls");
        HashMap params = new HashMap();

        if (!filePdf.exists()) {
            filePdf.mkdirs();
        }
        if (!fileHtml.exists()) {
            fileHtml.mkdirs();
        }
        if (!fileXls.mkdirs()) {
            fileXls.mkdir();
        }

        try {
            saveReportToPdf(resource.getFile().getAbsolutePath(),
                    filePdf.getAbsolutePath() + "/income_" + type + ".pdf", params);
            saveReportToHtml(resource.getFile().getAbsolutePath(),
                    fileHtml.getAbsolutePath() + "/income_" + type + ".html", params);
            saveReportToXls(resource.getFile().getAbsolutePath(),
                    fileXls.getAbsolutePath() + "/income_" + type + ".xls", params);
        } catch (JRException | SQLException | IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            result = ex.getMessage();
        }
        return result;
    }
    
    public String generateCustomerReport(Integer top) {
        String result = "success";
        Resource resource = new ClassPathResource("/META-INF/top_customer.jasper");
        String resourcePath = servletContext.getRealPath("/Resources");
       
        File filePdf = new File(resourcePath + "/reports/pdf");
        File fileHtml = new File(resourcePath + "/reports/html");
        File fileXls = new File(resourcePath + "/reports/xls");
        HashMap params = new HashMap();
        if (top != null) {
            params.put("limit_top", top);
        }

        if (!filePdf.exists()) {
            filePdf.mkdirs();
        }
        if (!fileHtml.exists()) {
            fileHtml.mkdirs();
        }
        if (!fileXls.exists()) {
            fileXls.mkdirs();
        }

        try {
            saveReportToPdf(resource.getFile().getAbsolutePath(),
                    filePdf.getAbsolutePath() + "/top_customer.pdf", params);
            saveReportToHtml(resource.getFile().getAbsolutePath(),
                    fileHtml.getAbsolutePath() + "/top_customer.html", params);
            saveReportToXls(resource.getFile().getAbsolutePath(),
                    fileXls.getAbsolutePath() + "/top_customer.xls", params);
        } catch (JRException | SQLException | IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            result = ex.getMessage();
        }
        return result;
    }
}
