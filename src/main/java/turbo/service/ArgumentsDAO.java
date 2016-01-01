/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import turbo.POJO.Arguments;

/**
 *
 * @author LeeSan
 */
public interface ArgumentsDAO extends DAO<Arguments> {

    public Arguments getArgumentByName(String name);
    
}
