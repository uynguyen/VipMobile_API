/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author LeeSan
 */
public interface DAO<T extends Object> {

    boolean create(T t);

    T get(Serializable id);

    T load(Serializable id);

    List<T> getAll();

    void update(T t);

    void delete(T t);

    void deleteById(Serializable id);

    void deleteAll();

    long count();

    boolean exists(Serializable id);
}
