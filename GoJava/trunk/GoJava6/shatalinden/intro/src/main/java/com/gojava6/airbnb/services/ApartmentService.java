package com.gojava6.airbnb.services;

import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.dao.ApartmentDao;

import java.util.List;

public class ApartmentService {

    public static List<Apartment> pullApartmentsByCity(String city) {
        return ApartmentDao.pullApartmentsByCity(city);
    }

    public static List<Apartment> pullApartmentsByUserID(int id) {
        return ApartmentDao.pullApartmentsByUserID(id);
    }

    public static void pushApartment(Apartment apartment) {
        ApartmentDao.pushApartment(apartment);
    }
}
