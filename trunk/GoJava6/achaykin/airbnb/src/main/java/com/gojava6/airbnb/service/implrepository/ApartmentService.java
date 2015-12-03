package com.gojava6.airbnb.service.implrepository;

import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.apartment.CityType;
import com.gojava6.airbnb.service.ApartmentServiceInterface;

import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 22.11.2015
 */
public class ApartmentService implements ApartmentServiceInterface {
    @Override
    public void create(Apartment apartment) {

    }

    @Override
    public Apartment retrieve(int apartmentID) {
        return null;
    }

    @Override
    public List<Apartment> retrieveAllByCity(CityType city) {
        return null;
    }

    @Override
    public void update(Apartment apartment) {

    }

    @Override
    public void delete(int Apartment) {

    }
}
