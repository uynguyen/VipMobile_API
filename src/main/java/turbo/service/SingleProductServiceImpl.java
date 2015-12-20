/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turbo.POJO.ProductDetail;

/**
 *
 * @author LeeSan
 */
@Service("singleProductService")
@Transactional
public class SingleProductServiceImpl implements SingleProductService {

    @Autowired
    private SingleProductDAO singleProductDAO;

    public ProductDetail getProductDetail(int idProduct) {
        return singleProductDAO.getProductDetail(idProduct);
                
    }

}
