package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.dbutils.HibernateDbUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Collections;
import java.util.List;

public class HibernateDefaultDao {
    protected SessionFactory sessionFactory = HibernateDbUtils.getSessionFactory();
    protected Class clazz;

    public HibernateDefaultDao(Class clazz) {
        this.clazz = clazz;
    }

    protected void save(Object entity){
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

//    protected <T> T get(Integer id) {
    protected Object get(Integer id) {
        Session session = sessionFactory.openSession();
        Object entity = null;

        try {
            session.beginTransaction();

            entity = session.get(clazz, id);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return entity;
    }

    protected boolean update(Object entity) {
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

    protected boolean delete(Integer id) {
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

    protected <T> List<T> getAll() {
        Session session = sessionFactory.openSession();
        List<T> list = Collections.emptyList();

        try {
            session.beginTransaction();

            list = session.createCriteria(clazz).list();

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }
}
