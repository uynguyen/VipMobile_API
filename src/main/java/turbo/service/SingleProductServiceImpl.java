/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.Collection;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turbo.POJO.Product;
import turbo.POJO.ProductColorDetail;
import turbo.POJO.ProductDetail;
import turbo.model.ProductDetailModel;

/**
 *
 * @author LeeSan
 */
@Service("singleProductService")
@Transactional
public class SingleProductServiceImpl implements SingleProductService {

    @Autowired
    private SingleProductDAO singleProductDAO;

    @Autowired
    private ProductService productService;

    public ProductDetailModel getProductDetail(int idProduct) {
        ProductDetailModel result = new ProductDetailModel();
        Product p = productService.getProduct(idProduct);
        result.setProduct(p);
        Collection<ProductDetail> details = p.getProductDetailCollection();

        if (details != null && details.size() > 0) {
            ProductDetail detail = (ProductDetail) p.getProductDetailCollection().toArray()[0];
            result.setProduct_detail(detail);
            result.setProducer(detail.getIdProducer().getValue());
        }

        Collection<ProductColorDetail> colorDetail = p.getProductColorDetailCollection();
        if (colorDetail != null) {
            for (int i = 0; i < colorDetail.size(); i++) {

                ProductColorDetail item = (ProductColorDetail) colorDetail.toArray()[i];
                result.getColorDetail().add(item.getIdColor().getValue());
            }
        }
        return result;

    }

}
