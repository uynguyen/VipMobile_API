/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import turbo.POJO.ProducerCategory;
import turbo.POJO.Product;

/**
 *
 * @author LeeSan
 */
@Repository
public class HbnProducerDAO extends AbstractHbnDAO<ProducerCategory> implements ProducerDAO {

    public ProducerCategory getProducerCategoryByValue(String value) {
        ProducerCategory result = null;
        Session ss = getSession();
        ss.beginTransaction();

        result = (ProducerCategory) ss.getNamedQuery("ProducerCategory.findByValue").setString("value", value).uniqueResult();

        return result;

    }

}
