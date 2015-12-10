package com.gojava6.airbnb.service.implrepository;

import com.gojava6.airbnb.model.apartment.ReserveApartment;
import com.gojava6.airbnb.service.IReserveService;

import java.util.Date;
import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 22.11.2015
 */
public class ReservationService implements IReserveService {
    @Override
    public void create(int apartmentID, int hostID, int renterID, Date checkIN, Date checkOUT) {

    }

    @Override
    public List<ReserveApartment> retrieveApartmentByID(int apartmentID) {
        return null;
    }

    @Override
    public List<ReserveApartment> retrieveApartmentsByHostID(int hostID) {
        return null;
    }

    @Override
    public void update(int apartmentID, int hostID, int renterID, Date oldCheckIN, Date oldCheckOUT, Date newCheckIN, Date newCheckOut) {

    }

    @Override
    public void delete(int apartmentID, int hostID, int renterID, Date checkIN, Date checkOUT) {

    }

    @Override
    public boolean isReserved(int apartmentID, Date checkIN, Date checkOUT) {
        return false;
    }
}
