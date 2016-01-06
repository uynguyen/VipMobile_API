/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import turbo.POJO.Arguments;
import turbo.POJO.ColorCategory;

/**
 *
 * @author LeeSan
 */
@Transactional
@Repository
public class HbnArgumentsDAO extends AbstractHbnDAO<Arguments> implements ArgumentsDAO {

    @Override
    public Arguments getArgumentByName(String name) {
        Arguments result = null;
        Session ss = getSession();
        ss.beginTransaction();

        result = (Arguments) ss.getNamedQuery("Arguments.findByName").setString("name", name).uniqueResult();

        return result;
    }

}
