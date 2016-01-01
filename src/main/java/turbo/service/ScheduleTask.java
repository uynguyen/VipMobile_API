/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author 12125
 */

@Service
@Async
@EnableScheduling
public class ScheduleTask {

    @Autowired
    private Report report;


    @Scheduled(fixedDelay = Long.MAX_VALUE)
    public void initIncomeReport() {
        autoCreateMonthlyIncomeReport();
        autoCreateQuarterlyIncomeReport();
        autoCreateWeeklyIncomeReport();
        autoCreateYearlyIncomeReport();
    }

    @Scheduled(cron = "0 0 0 ? * SAT")
    public void autoCreateWeeklyIncomeReport() {
        System.out.println("Auto generate week income report in " + (new Date()).toString());
        report.generateIncomeReport("week");
    }

    @Scheduled(cron = "0 0 0 28 * ?")
    public void autoCreateMonthlyIncomeReport() {
        System.out.println("Auto generate month income report in " + (new Date()).toString());
        report.generateIncomeReport("month");
    }

    @Scheduled(cron = "0 0 0 28 3/3 ?")
    public void autoCreateQuarterlyIncomeReport() {
        System.out.println("Auto generate quarter income report in " + (new Date()).toString());
        report.generateIncomeReport("quarter");
    }

    @Scheduled(cron = "0 0 0 31 12 ?")
    public void autoCreateYearlyIncomeReport() {
        System.out.println("Auto generate year income report in " + (new Date()).toString());
        report.generateIncomeReport("year");
    }
    
    @Scheduled(fixedDelay = 86400000)
    public void autoCreateDailyCustomerReport() {
        System.out.println("Auto generate daily customer report in " + (new Date()).toString());
        report.generateCustomerReport(100);
    }
}
