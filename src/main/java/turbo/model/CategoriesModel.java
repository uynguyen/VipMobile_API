/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.model;

import java.io.Serializable;
import java.util.ArrayList;
import turbo.POJO.ColorCategory;
import turbo.POJO.ProducerCategory;

/**
 *
 * @author LeeSan
 */
public class CategoriesModel implements Serializable {

    ArrayList<ProducerCategory> listProducers = new ArrayList<>();
    ArrayList<ColorCategory> listcolors = new ArrayList<>();

    public CategoriesModel() {
    }

    public ArrayList<ProducerCategory> getListProducers() {
        return listProducers;
    }

    public void setListProducers(ArrayList<ProducerCategory> listProducers) {
        this.listProducers = listProducers;
    }

    public ArrayList<ColorCategory> getListcolors() {
        return listcolors;
    }

    public void setListcolors(ArrayList<ColorCategory> listcolors) {
        this.listcolors = listcolors;
    }
    
    
}
