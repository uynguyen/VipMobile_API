/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.controller;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import turbo.service.ScheduleTask;
import turbo.service.Report;

/**
 *
 * @author Vinlq
 */
@RestController
@RequestMapping(value = "/report")
public class ReportController {

    @Autowired
    private Report report;
    
    
    public ReportController() {
        super();
    }

    @RequestMapping(value = {"/customer/generate/{top}"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> createCustomerReport(@PathVariable("top") Integer top) {
        String result = report.generateCustomerReport(top);
        ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
        return entity;
    }

    @RequestMapping(value = {"/income/generate/{typeReport}"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> createIncomeReport(@PathVariable("typeReport") String type) {
        String result = report.generateIncomeReport(type);
        ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
        return entity;
    }

    

    @RequestMapping(value = "/customer/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getTopCustomerReport(HttpServletRequest request)
            throws IOException {
        String address = "http://"
                + request.getServerName()
                + ":" + request.getServerPort()
                + request.getContextPath();

        String pathHtml = address + "/Resources/reports/html/top_customer.html";
        String pathPdf = address + "/Resources/reports/pdf/top_customer.pdf";
        String pathXls = address + "/Resources/reports/xls/top_customer.xls";

        JSONObject res = new JSONObject();

        res.put("linkHtml", pathHtml);
        res.put("linkPdf", pathPdf);
        res.put("linkXls", pathXls);

        ResponseEntity<String> entity = new ResponseEntity<String>(res.toString(), HttpStatus.OK);
        return entity;
    }

    
    
    @RequestMapping(value = "/income/{typeReport}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getIncomeReport(@PathVariable("typeReport") String type, HttpServletRequest request)
            throws IOException {
        String address = "http://"
                + request.getServerName()
                + ":" + request.getServerPort()
                + request.getContextPath();

        String pathHtml = address + "/Resources/reports/html/income_"+type+".html";
        String pathPdf = address + "/Resources/reports/pdf/income_"+type+".pdf";
        String pathXls = address + "/Resources/reports/xls/income_"+type+".xls";

        JSONObject res = new JSONObject();

        res.put("linkHtml", pathHtml);
        res.put("linkPdf", pathPdf);
        res.put("linkXls", pathXls);

        ResponseEntity<String> entity = new ResponseEntity<String>(res.toString(), HttpStatus.OK);
        return entity;
    }
   
}
