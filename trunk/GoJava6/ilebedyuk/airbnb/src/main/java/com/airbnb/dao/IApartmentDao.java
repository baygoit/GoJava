package com.airbnb.dao;

import com.airbnb.model.Apartment;

import java.util.List;

/**
 * Created by Игорь on 11.10.2015.
 */
public interface IApartmentDao {
    List<Apartment> getApartmentList();
    Apartment getApartment(int id);
    void delete(int id);
    void addToDb(Apartment apartment);
}
