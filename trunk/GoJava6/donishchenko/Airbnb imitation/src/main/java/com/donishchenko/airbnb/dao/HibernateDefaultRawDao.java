package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.dbutils.HibernateDbUtils;
import com.donishchenko.airbnb.dbutils.QueryBuilder;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Collections;
import java.util.List;

public class HibernateDefaultRawDao {
    private SessionFactory sessionFactory = HibernateDbUtils.getSessionFactory();
    private Class clazz;
    private String defaultQueryString;

    public HibernateDefaultRawDao(Class clazz) {
        this.clazz = clazz;
        this.defaultQueryString = "FROM " + clazz.getSimpleName();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void save(Object entity) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            session.save(entity);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public <T> T get(Integer id) {
        Session session = sessionFactory.openSession();
        T entity = null;

        try {
            session.beginTransaction();

            entity = (T) session.get(clazz, id);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return entity;
    }

    public boolean update(Object entity) {
        Session session = sessionFactory.openSession();
        boolean updated = false;

        try {
            session.beginTransaction();

            session.update(entity);

            //TODO test merge
            // Retrieve existing person via id, then copy everything from detached person
            // to attached one, and return attached one
            //  session.merge(entity);

            session.getTransaction().commit();
            updated = true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return updated;
    }

    public boolean delete(Integer id) {
        Session session = sessionFactory.openSession();
        boolean deleted = false;

        try {
            session.beginTransaction();

            Object entity = session.load(clazz, id);
            session.delete(entity);

            session.getTransaction().commit();
            deleted = true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return deleted;
    }

    public <T> List<T> getList(Object...params) {
        QueryBuilder queryBuilder = new QueryBuilder(defaultQueryString);
        queryBuilder.parse(params);

        return getList(queryBuilder.getQuery(), queryBuilder.values().toArray());
    }

    //TODO try to extract some logic into separate method
    public <T> List<T> getList(String queryString, Object[] params) {
        Session session = sessionFactory.openSession();
        List<T> list = Collections.emptyList();

        Query query = session.createQuery(queryString);

        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }

        try {
            session.beginTransaction();
            list = (List<T>) query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }

    public <T> T getUniqueResult(Object...params) {
        QueryBuilder queryBuilder = new QueryBuilder(defaultQueryString);
        queryBuilder.parse(params);

        return getUniqueResult(queryBuilder.getQuery(), queryBuilder.values().toArray());
    }

    //TODO try to extract some logic into separate method
    public <T> T getUniqueResult(String queryString, Object[] params) {
        Session session = sessionFactory.openSession();
        T entity = null;

        Query query = session.createQuery(queryString);

        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }

        try {
            session.beginTransaction();
            entity = (T) query.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return entity;
    }
}
