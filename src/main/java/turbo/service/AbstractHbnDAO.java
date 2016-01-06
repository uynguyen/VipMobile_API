/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.service;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import turbo.POJO.UserBill;

/**
 *
 * @author LeeSan
 */
public abstract class AbstractHbnDAO<T extends Object> implements DAO<T> {

    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> domainClass;

    /**
     *
     * @return
     */
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Class<T> getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType
                    = (ParameterizedType) getClass().getGenericSuperclass();
            this.domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }

    private String getDomainClassName() {
        return getDomainClass().getName();
    }

    /**
     *
     * @param t
     */
    @Override
    public T create(T t) {

        try {
            getSession().saveOrUpdate(t);
            return t;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public T get(Serializable id) {
        return (T) getSession().get(getDomainClass(), id);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public T load(Serializable id) {
        return (T) getSession().load(getDomainClass(), id);
    }

    /**
     *
     * @return
     */
    @Override
    public List<T> getAll() {

        List<T> result = new ArrayList<T>();

        result = getSession().createCriteria(getDomainClass()).list();

        return result;
    }

    /**
     *
     * @param t
     */
    @Override
    public void update(T t) {
        getSession().update(t);
    }

    /**
     *
     * @param t
     */
    @Override
    public void delete(T t) {
        getSession().delete(t);
    }

    /**
     *
     * @param id
     */
    @Override
    public void deleteById(Serializable id) {
        delete(load(id));
    }

    /**
     *
     */
    @Override
    public void deleteAll() {
        getSession()
                .createQuery("delete "
                        + getDomainClassName()).executeUpdate();
    }

    /**
     *
     * @return
     */
    @Override
    public Long count() {
        return (Long) getSession().createCriteria(getDomainClass())
                .setProjection(Projections.rowCount()).uniqueResult();

    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public boolean exists(Serializable id) {
        return (get(id) != null);
    }
}
