package com.azuiev.dao;

import org.hibernate.Session;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masta on 06.11.15.
 */
public class BasicModelDao<T> implements ModelDao<T> {
    Class clazz;

    public BasicModelDao(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public List<T> getAll() throws SQLException {
        Session session = null;
        List<T> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(clazz).list();
        } catch (Exception e) {
            //TODO add logging
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }

    @Override
    public T getById(Long id) throws SQLException {
        Session session = null;
        T obj = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            obj = (T) session.get(clazz, id);

        } catch (Exception e) {
            //TODO add logging
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return obj;
    }

    @Override
    public void update(T obj) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.update(obj);
        } catch (Exception e) {
            //TODO add logging
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void add(T obj) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.save(obj);
        } catch (Exception e) {
            //TODO add logging
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(T obj) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.delete(obj);
        } catch (Exception e) {
            //TODO add logging
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
