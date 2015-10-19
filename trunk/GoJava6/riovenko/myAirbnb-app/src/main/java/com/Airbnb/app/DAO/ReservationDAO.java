package com.Airbnb.app.DAO;

import com.Airbnb.app.model.ApartType;
import com.Airbnb.app.model.Apartment;

import java.util.Date;
import java.util.List;

/**
 * Created by romanroma on 28.09.15.
 */
public interface ReservationDAO {
    public List<Apartment> searchApartements (ApartType apartType, String city, Date dateFrom, Date dateTo);
    public void makeRedservation ();
}
