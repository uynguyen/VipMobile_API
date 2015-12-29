/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author LeeSan
 */
public class UpdateUserBillModel implements Serializable{
    ArrayList<Integer> id_bills = new ArrayList<>();
    Integer id_state;

    public ArrayList<Integer> getId_bills() {
        return id_bills;
    }

    public void setId_bills(ArrayList<Integer> id_bills) {
        this.id_bills = id_bills;
    }

    public Integer getId_state() {
        return id_state;
    }

    public void setId_state(Integer id_state) {
        this.id_state = id_state;
    }

   
    
    
}
