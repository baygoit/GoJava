package com.azuiev.dao;

import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 06.11.15.
 */
public class AbstractModelDao implements ModelDao {
    Class clazz = Object.class;
    Object obj = new Object();
    @Override
    public List<?> getAll() throws SQLException {
        Session session = null;
        List<?> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(clazz).list();
        } catch (Exception e) {
            //NOP
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }

    @Override
    public Object getById(Long id) throws SQLException {
        Session session = null;
        obj = null;
        if(clazz!=null);
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            obj = session.load(clazz, id);
        } catch (Exception e) {
            //NOP
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return obj;
    }

    @Override
    public void update(Object obj) throws SQLException {

    }

    @Override
    public void add(Object obj) throws SQLException {

    }

    @Override
    public void delete(Object obj) throws SQLException {

    }
}
