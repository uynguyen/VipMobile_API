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
public class QueryProductStringModel implements Serializable{
    String searchString;
    Integer page;
    Integer limit;
    ArrayList<String> producers = new ArrayList<String>();
    ArrayList<Double> screenSize = new ArrayList<Double>();
    ArrayList<String> colors = new ArrayList<String>();
    Integer minPrice;
    Integer maxPrice;

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public ArrayList<String> getProducers() {
        return producers;
    }

    public void setProducers(ArrayList<String> producers) {
        this.producers = producers;
    }

    public ArrayList<Double> getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(ArrayList<Double> screenSize) {
        this.screenSize = screenSize;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    
}
