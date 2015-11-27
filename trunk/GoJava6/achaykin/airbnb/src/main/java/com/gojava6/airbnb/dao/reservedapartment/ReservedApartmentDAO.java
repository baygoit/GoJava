package com.gojava6.airbnb.dao.reservedapartment;

import com.gojava6.airbnb.Exception.daoexception.MySqlReservedApartmentDAOException;
import com.gojava6.airbnb.apartment.ReservedApartment;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public interface ReservedApartmentDAO {

    void create(int apartmentID, int hostID,int renterID, Date dateIN, Date dateOUT);

    ReservedApartment retrieveApartmentByID(int apartmentID);

    List<ReservedApartment> retrieveAoartmentsByHostID(int hostID);

    void update(int apartmentID, int hostID, int renterID,
                Date oldCheckIN, Date oldCheckOUT, Date newCheckIn, Date newCheckOut);

    void delete(int apartmentID, int hostID, int renterID, Date dateIN, Date dateOUT);

    boolean isReserved(int apartmentID, Date checkIN, Date checkOUT) throws MySqlReservedApartmentDAOException;
}
