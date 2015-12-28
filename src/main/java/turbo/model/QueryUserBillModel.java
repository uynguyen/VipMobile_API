/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author LeeSan
 */
public class QueryUserBillModel implements Serializable {

    private String query_str;
    private String date_time;

 

    public String getQuery_str() {
        return query_str;
    }

    public void setQuery_str(String query_str) {
        this.query_str = query_str;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    


}
