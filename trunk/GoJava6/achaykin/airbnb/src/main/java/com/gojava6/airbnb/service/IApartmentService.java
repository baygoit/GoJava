package com.gojava6.airbnb.service;

import com.gojava6.airbnb.model.apartment.Apartment;
import com.gojava6.airbnb.model.apartment.CityType;

import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 22.11.2015
 */
public interface IApartmentService {

    void create(Apartment apartment);

    Apartment retrieveByID(int apartmentID);

    List<Apartment> retrieveAllByCity(CityType city);

    List<Apartment> retrieveAllByHost(int hostID);

    void update(Apartment apartment);

    void delete(int apartment);

}

