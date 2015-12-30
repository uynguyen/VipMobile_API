/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.common;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import turbo.bussiness.RegisterEmailHandler;

/**
 *
 * @author LeeSan
 */
public class AppArguments {

    private Properties props;

    public AppArguments() {
        Resource resource = new ClassPathResource("/META-INF/Argument.properties");
        try {
            this.props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException ex) {
            Logger.getLogger(RegisterEmailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }
    
    
}
