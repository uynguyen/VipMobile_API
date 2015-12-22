/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.strategySearch;

import java.util.ArrayList;
import turbo.POJO.Product;
import turbo.model.QueryProductStringModel;

/**
 *
 * @author LeeSan
 */
public interface StrategySearch {
    public ArrayList<Product> Search(ArrayList<Product> lstProducts,QueryProductStringModel query);
    
}
