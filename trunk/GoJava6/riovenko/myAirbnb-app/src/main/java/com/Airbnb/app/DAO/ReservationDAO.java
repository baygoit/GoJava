package com.Airbnb.app.DAO;

import com.Airbnb.app.model.ApartType;
import com.Airbnb.app.model.Apartment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by romanroma on 28.09.15.
 */
public interface ReservationDAO {
    public void makeReservation (int apartmentId, Date dateFrom, Date dateTo) throws SQLException;
    public List<Integer> searchPossibleApartment (String city, ApartType apartType,
                                                       Date dateFrom, Date dateTo) throws SQLException;
}
