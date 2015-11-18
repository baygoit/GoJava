package com.azuiev.dao;

import com.azuiev.model.Apartment;
import org.hibernate.Session;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 02.11.15.
 */
//TODO reimplement metods
public class ApartmentDao implements ModelDao {


    static ModelDao dao = new BasicModelDao(new Apartment());
    @Override
    public List<Apartment> getAll() throws SQLException {
        return (List<Apartment>) dao.getAll();
    }


    @Override
    public Apartment getById(Long id) throws SQLException {

        Apartment Apartment = (Apartment) dao.getById(id);
        return Apartment;
    }

    public List<Apartment> getByCity(Long id) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Apartment> list = session.createQuery("from Apartment where city = "+ id).list();
        return list;


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
