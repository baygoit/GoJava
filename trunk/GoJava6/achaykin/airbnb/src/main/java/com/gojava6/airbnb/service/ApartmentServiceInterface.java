package com.gojava6.airbnb.service;

import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.apartment.CityType;

import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 22.11.2015
 */
public interface ApartmentServiceInterface {

    void create(Apartment apartment);

    Apartment retrieve(int apartmentID);

    List<Apartment> retrieveAllByCity(CityType city);

    void update(Apartment apartment);

    void delete(int Apartment);

}

