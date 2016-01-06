/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import turbo.bussiness.PaypalConfig;

/**
 *
 * @author 12125
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
       System.out.println("Start application!");
       
       PaypalConfig.initConfig();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Stop application!");
    }
    
}
