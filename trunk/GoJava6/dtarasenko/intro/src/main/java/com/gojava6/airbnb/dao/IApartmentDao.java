package com.gojava6.airbnb.dao;

import com.gojava6.airbnb.model.Apartment;

import java.util.List;

public interface IApartmentDao {

    void createApartment(Apartment apartment);
    void updateApartment(Apartment apartment);
    void deleteApartment(Apartment apartment);
    List<Apartment> getApartmentList();
    Apartment getApartment(Integer apartmentId);

}
