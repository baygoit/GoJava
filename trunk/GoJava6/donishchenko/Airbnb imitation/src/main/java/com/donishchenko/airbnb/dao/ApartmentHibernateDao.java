package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.dbutils.HibernateDefaultRawDao;
import com.donishchenko.airbnb.model.Apartment;

import java.util.List;

public class ApartmentHibernateDao implements ApartmentDao {
    private HibernateDefaultRawDao defaultDao = new HibernateDefaultRawDao(Apartment.class);

    public ApartmentHibernateDao() {}

    @Override
    public void save(Apartment apartment) {
        defaultDao.save(apartment);
    }

    @Override
    public Apartment get(Integer id) {
        return defaultDao.get(id);
    }

    @Override
    public boolean update(Apartment apartment) {
        return defaultDao.update(apartment);
    }

    @Override
    public boolean delete(Integer id) {
        return defaultDao.delete(id);
    }

    @Override
    public List<Apartment> getAll() {
        return defaultDao.getList();
    }

    @Override
    public List<Apartment> getAllByCity(String city) {
        return defaultDao.getList("city.name", city);
    }

    @Override
    public List<Apartment> getAllByUser(Integer id) {
        return defaultDao.getList("host.id", id);
    }
}
