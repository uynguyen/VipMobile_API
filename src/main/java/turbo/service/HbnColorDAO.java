/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import turbo.POJO.ColorCategory;
import turbo.POJO.ProducerCategory;
import turbo.POJO.ProductColorDetail;

/**
 *
 * @author LeeSan
 */
@Repository
public class HbnColorDAO extends AbstractHbnDAO<ColorCategory> implements ColorDAO {

    public ColorCategory getProductColorDetailByValue(String value) {
        ColorCategory result = null;
        Session ss = getSession();
        ss.beginTransaction();

        result = (ColorCategory) ss.getNamedQuery("ColorCategory.findByValue").setString("value", value).uniqueResult();

        return result;
    }

}
