package com.azuiev.dao;

import com.azuiev.model.City;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 06.11.15.
 */
public class BasicModelDao implements ModelDao {
    Object model;

    public BasicModelDao(Object model) {
        this.model = model;
    }

    @Override
    public List<?> getAll() throws SQLException {
        Session session = null;
        List<?> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(model.getClass()).list();
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
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            model = session.get(model.getClass(), id);
            System.out.println("ttt");

        } catch (Exception e) {
            //TODO
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return model;
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
