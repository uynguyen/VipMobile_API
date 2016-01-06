/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.AbstractList;
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
import turbo.model.ArrayObjectModel;
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

    @Autowired
    private UserBillDetailDAO billDetailDAO;

    @Override
    public List<Product> getProducts(int page, int limit) {
        ArrayList<Product> result = productDAO.getProducts(page, limit);

        return result;
    }

    @Override
    public Product getProduct(Integer id) {
        return productDAO.get(id);
    }

    public ArrayObjectModel searchProduct(QueryProductStringModel query) {

        ArrayList<Product> result = new ArrayList<Product>();
        StrategySearch searchMachine;
        query.setPage(query.getPage() - 1);
        boolean flag_isFirstTime = true;
        if (query.getProducers() != null && !query.getProducers().isEmpty()) {
            searchMachine = new SearchByProducer(producerDAO);
            result = searchMachine.Search(result, query, flag_isFirstTime);
            flag_isFirstTime = false;
        }

        if (query.getMinPrice() != null && query.getMaxPrice() != null) {
            searchMachine = new SearchByPrice(productDAO);
            result = searchMachine.Search(result, query, flag_isFirstTime);

        }
        if (query.getColors() != null && !query.getColors().isEmpty()) {
            searchMachine = new SearchByColor(colorDAO, productDAO);
            result = searchMachine.Search(result, query, flag_isFirstTime);
        }

        if (query.getScreenSize() != null && !query.getScreenSize().isEmpty()) {
            searchMachine = new SearchByScreenSize(productDAO);
            result = searchMachine.Search(result, query, flag_isFirstTime);
        }
        if (query.getSearchString() != null && query.getSearchString() != "") {
            searchMachine = new SearchByStringQuery(productDAO);
            result = searchMachine.Search(result, query, flag_isFirstTime);

        }
        ArrayObjectModel model = new ArrayObjectModel();

        sortListProducts(result);
        model.setTotal(result.size());
        result = Paging(result, query.getPage(), query.getLimit());

        model.setResult(result);
        return model;
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

    @Override
    public List<Product> getBestSaleProduct(int page, int limit) {
        return billDetailDAO.getBestSaleProducts(page, limit);
    }

    @Override
    public List<Product> getNewProduct(int page, int limit) {
        return productDAO.getNewProduct(page, limit);
    }

    @Override
    public List<Product> getHighProduct(int limit) {
        return productDAO.getHighProduct(limit);
    }

}
