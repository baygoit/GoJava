package com.donishchenko.airbnb.services;

import com.donishchenko.airbnb.dao.ApartmentDao;
import com.donishchenko.airbnb.dao.CityDao;
import com.donishchenko.airbnb.dao.CityHibernateDao;
import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.City;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SearchService {
//    @Autowired
    private CityDao cityDao = new CityHibernateDao();

    @Autowired
    private ApartmentDao apartmentDao;

    public List<City> getAllCities() {
        return cityDao.getAll();
    }

    public List<Apartment> getAllApartmentsByCity(String city) {
        return apartmentDao.getAllByCity(city);
    }
}
