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

    /**
     *
     * @param t
     */
    T create(T t);

    /**
     *
     * @param id
     * @return
     */
    T get(Serializable id);

    /**
     *
     * @param id
     * @return
     */
    T load(Serializable id);

    /**
     *
     * @return
     */
    List<T> getAll();

    /**
     *
     * @param t
     */
    void update(T t);

    /**
     *
     * @param t
     */
    void delete(T t);

    /**
     *
     * @param id
     */
    void deleteById(Serializable id);

    /**
     *
     */
    void deleteAll();

    /**
     *
     * @return
     */
    Long count();

    /**
     *
     * @param id
     * @return
     */
    boolean exists(Serializable id);
}
