package com.gojava6.airbnb.service;

import com.gojava6.airbnb.model.apartment.ReserveApartment;

import java.util.Date;
import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 22.11.2015
 */
public interface IReserveService {

    void create(int apartmentID, int hostID, int renterID, Date checkIN, Date checkOUT);

    List<ReserveApartment> retrieveApartmentByID(int apartmentID);

    List<ReserveApartment> retrieveApartmentsByHostID(int hostID);

    void update(int apartmentID, int hostID, int renterID, Date oldCheckIN, Date oldCheckOUT,
                Date newCheckIN, Date newCheckOut);

    void delete(int apartmentID, int hostID, int renterID, Date checkIN, Date checkOUT);

    boolean isReserved(int apartmentID, Date checkIN, Date checkOUT);

}
