package com.azuiev.dao;

import com.azuiev.model.Apartment;
import org.hibernate.Session;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Masta on 02.11.15.
 */
//TODO reimplement metods
public class ApartmentDao implements ModelDao<Apartment> {

    static ModelDao dao = new BasicModelDao<Apartment>(Apartment.class);
    @Override
    public List<Apartment> getAll() throws SQLException {
        return dao.getAll();
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
    public void update(Apartment apartment) throws SQLException {
        dao.update(apartment);
    }

    @Override
    public void add(Apartment apartment) throws SQLException {
        dao.add(apartment);
    }

    @Override
    public void delete(Apartment apartment) throws SQLException {
        dao.delete(apartment);
    }
}
