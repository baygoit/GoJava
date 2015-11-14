package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.dbutils.HibernateDefaultRawDao;
import com.donishchenko.airbnb.model.City;

import java.util.List;

public class CityHibernateDao implements CityDao {
    private HibernateDefaultRawDao defaultDao = new HibernateDefaultRawDao(City.class);

    public CityHibernateDao() {}

    @Override
    public void save(City city) {
        defaultDao.save(city);
    }

    @Override
    public City get(Integer id) {
        return defaultDao.get(id);
    }

    @Override
    public boolean update(City city) {
        return defaultDao.update(city);
    }

    @Override
    public boolean delete(Integer id) {
        return defaultDao.delete(id);
    }

    @Override
    public List<City> getAll() {
        return defaultDao.getList();
    }

    @Override
    public City getByName(String name) {
        return defaultDao.getUniqueResult("name", name);
    }
}
