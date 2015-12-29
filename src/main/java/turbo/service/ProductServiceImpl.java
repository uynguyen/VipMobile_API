/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turbo.POJO.ColorCategory;
import turbo.POJO.ProducerCategory;
import turbo.POJO.Product;
import turbo.POJO.ProductDetail;
import turbo.POJO.SaleProduct;
import turbo.model.QueryProductStringModel;
import turbo.strategySearch.SearchByColor;
import turbo.strategySearch.SearchByPrice;
import turbo.strategySearch.SearchByProducer;
import turbo.strategySearch.SearchByScreenSize;
import turbo.strategySearch.SearchByStringQuery;
import turbo.strategySearch.StrategySearch;

/**
 *
 * @author LeeSan
 */
@Service("productService")
@Transactional
public class ProductServiceImpl extends RootService implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProducerDAO producerDAO;

    @Autowired
    private ColorDAO colorDAO;

    @Autowired
    private SingleProductDAO singleProductDAO;

    @Autowired
    private SaleProductDAO saleProductDAO;

    @Override
    public void createProduct(Product contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getProducts() {
        List<Product> result = productDAO.getAll();

        return result;
    }

    @Override
    public List<Product> getProductByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getProduct(Integer id) {
        return productDAO.get(id);
    }

    @Override
    public void updateProduct(Product contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProduct(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Product> searchProduct(QueryProductStringModel query) {
        ArrayList<Product> result = new ArrayList<Product>();
        StrategySearch searchMachine;
        if (query.getProducers() != null && !query.getProducers().isEmpty()) {
            searchMachine = new SearchByProducer(producerDAO);
            result = searchMachine.Search(result, query);
        }

        if (query.getMinPrice() != null && query.getMaxPrice() != null) {
            searchMachine = new SearchByPrice(productDAO);
            result = searchMachine.Search(result, query);

        }
        if (query.getColors() != null && !query.getColors().isEmpty()) {
            searchMachine = new SearchByColor(colorDAO);
            result = searchMachine.Search(result, query);
        }

        if (query.getScreenSize() != null && !query.getScreenSize().isEmpty()) {
            searchMachine = new SearchByScreenSize(productDAO);
            result = searchMachine.Search(result, query);
        }
        if (query.getSearchString() != null && query.getSearchString() != "") {
            searchMachine = new SearchByStringQuery(productDAO);
            result = searchMachine.Search(result, query);

        }

        if (result.isEmpty()) {
            result = productDAO.getProducts(query.getPage(), query.getLimit());

            return result;
        }

        sortListProducts(result);

        result = Paging(result, query.getPage(), query.getLimit());

        return result;
    }

    private void sortListProducts(ArrayList<Product> lst) {
        Collections.sort(lst, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {

                return p1.getPrice().compareTo(p2.getPrice());
            }
        });
    }

    @Override
    public List<SaleProduct> getSaleProducts(int page, int limit) {
        return saleProductDAO.getSaleProducts(page, limit);
    }

    @Override
    public ArrayList<ProducerCategory> getProducerCategory() {
        return (ArrayList<ProducerCategory>) producerDAO.getAll();
    }

    @Override
    public ArrayList<ColorCategory> getColorCategory() {
        return (ArrayList<ColorCategory>) colorDAO.getAll();
    }

}
