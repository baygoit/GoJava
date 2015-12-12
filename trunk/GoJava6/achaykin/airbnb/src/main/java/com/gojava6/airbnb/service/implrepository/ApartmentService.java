package com.gojava6.airbnb.service.implrepository;

import com.gojava6.airbnb.model.apartment.Apartment;
import com.gojava6.airbnb.model.apartment.CityType;
import com.gojava6.airbnb.service.IApartmentService;

import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 22.11.2015
 */
public class ApartmentService implements IApartmentService {
    @Override
    public void create(Apartment apartment) {

    }

    @Override
    public Apartment retrieveByID(int apartmentID) {
        return null;
    }

    @Override
    public List<Apartment> retrieveAllByCity(CityType city) {
        return null;
    }

    @Override
    public List<Apartment> retrieveAllByHost(int hostID) {
        return null;
    }

    @Override
    public void update(Apartment apartment) {

    }

    @Override
    public void delete(int apartment) {

    }
}
