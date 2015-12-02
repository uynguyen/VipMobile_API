/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.util.List;
import turbo.POJO.Product;

/**
 *
 * @author LeeSan
 */
public interface ProductService {

    void createContact(Product contact);

    List<Product> getContacts();

    List<Product> getContactsByEmail(String email);

    Product getContact(Long id);

    void updateContact(Product contact);

    void deleteContact(Long id);
}
