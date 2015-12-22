/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.strategySearch;

import java.util.ArrayList;
import java.util.Collection;
import turbo.POJO.ProducerCategory;
import turbo.POJO.Product;
import turbo.POJO.ProductDetail;
import turbo.model.QueryProductStringModel;
import turbo.service.ProducerDAO;

/**
 *
 * @author LeeSan
 */
public class SearchByProducer implements StrategySearch {

    private ProducerDAO producerDAO;

    public SearchByProducer(ProducerDAO dao) {
        this.producerDAO = dao;
    }

    @Override
    public ArrayList<Product> Search(ArrayList<Product> lstProduct, QueryProductStringModel query) {
        ArrayList<Product> result = new ArrayList<Product>();
        if (lstProduct.size() != 0) {
            for (Product p : lstProduct) {
                Collection<ProductDetail> detail = p.getProductDetailCollection();
                if (detail != null && detail.toArray().length != 0) {
                    String producerName = ((ProductDetail) detail.toArray()[0]).getIdProducer().getValue();
                    if (query.getProducers().contains(producerName)) {
                        result.add(p);
                    }
                }
            }
            return result;
        }

        for (String producerName : query.getProducers()) {
            ProducerCategory producer = producerDAO.getProducerCategoryByValue(producerName);
            if (producer != null) {
                Collection<ProductDetail> productDetailBelongToProducer = producer.getProductDetailCollection();
                if (productDetailBelongToProducer != null && productDetailBelongToProducer.size() != 0) {
                    for (int i = 0; i < productDetailBelongToProducer.size(); i++) {
                        ProductDetail detail = (ProductDetail) productDetailBelongToProducer.toArray()[i];
                        Product p = detail.getIdProduct();
                        if (p != null) {
                            result.add(p);
                        }
                    }
                }
            }
        }

        return result;
    }

}
