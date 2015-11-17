package com.azuiev.dao;

import com.azuiev.model.Apartment;
import com.azuiev.model.City;
<<<<<<< HEAD
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
=======
import com.azuiev.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
>>>>>>> 369492fefa35007740916941c8076d64c3c7e213
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 02.11.15.
 */
//TODO reimplement metods
public class ApartmentDao implements ModelDao {
<<<<<<< HEAD

    static ModelDao dao = new BasicModelDao(new Apartment());
    @Override
    public List<Apartment> getAll() throws SQLException {
=======

    static ModelDao dao = new AbstractModelDao(new Apartment());

    @Override
    public List<?> getAll() throws SQLException {
>>>>>>> 369492fefa35007740916941c8076d64c3c7e213
        return (List<Apartment>) dao.getAll();
    }


    @Override
    public Apartment getById(Long id) throws SQLException {
<<<<<<< HEAD
        Apartment Apartment = (Apartment) dao.getById(id);
        return Apartment;
    }

    public List<Apartment> getByCity(Long id) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Apartment> list = session.createQuery("from Apartment where city = "+ id).list();
        return list;
=======

        return null;

    }

    public List<Apartment> getByCity(Long id) throws SQLException {

        return null;
>>>>>>> 369492fefa35007740916941c8076d64c3c7e213
    }

    @Override
    public void update(Object obj) {
        //TODO
    }

    @Override
    public void add(Object obj) {
        //TODO
    }

    @Override
    public void delete(Object obj) {
        //TODO
    }
}
