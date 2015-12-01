package com.gojava6.airbnb.service;

import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.apartment.ReservedApartment;

import java.util.Date;
import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 22.11.2015
 */
public interface ReservationServiceInterface {

    void create(ReservedApartment reserve);
    
    ReservedApartment retrieve(int apartmentID);

    List<ReservedApartment> retrieveAllByApartmID(int apartmentID);

    void update(int apartmentID, Date oldCheckIN, Date oldCheckOUT, Date newCheckIN, Date newCheckOUT);

    void delete(int apartmentID, Date checkIN, Date checkOUT);

    boolean isFreeOnDate(int apartmentID, Date checkIN, Date checkOUT);

}
