package com.gojava6.airbnb.service.implrepository;

import com.gojava6.airbnb.apartment.ReservedApartment;
import com.gojava6.airbnb.service.ReservationServiceInterface;

import java.util.Date;
import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 22.11.2015
 */
public class ReservationService implements ReservationServiceInterface {
    @Override
    public void create(ReservedApartment reserve) {

    }

    @Override
    public ReservedApartment retrieve(int apartmentID) {
        return null;
    }

    @Override
    public List<ReservedApartment> retrieveAllByApartmID(int apartmentID) {
        return null;
    }

    @Override
    public void update(int apartmentID, Date oldCheckIN, Date oldCheckOUT, Date newCheckIN, Date newCheckOUT) {

    }

    @Override
    public void delete(int apartmentID, Date checkIN, Date checkOUT) {

    }

    @Override
    public boolean isFreeOnDate(int apartmentID, Date checkIN, Date checkOUT) {
        return false;
    }
}
