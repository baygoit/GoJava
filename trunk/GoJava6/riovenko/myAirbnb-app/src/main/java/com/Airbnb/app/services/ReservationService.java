package com.Airbnb.app.services;

import com.Airbnb.app.DAO.ApartmentDAO;
import com.Airbnb.app.DAO.ApartmentDAOimpl;
import com.Airbnb.app.DAO.ReservationDAO;
import com.Airbnb.app.DAO.ReservationDAOImpl;
import com.Airbnb.app.model.ApartType;
import com.Airbnb.app.model.Apartment;

import java.sql.SQLException;
import java.util.IntSummaryStatistics;

/**
 * Created by romanroma on 18.10.15.
 */
public class ReservationService {
    ApartmentDAO apartmentDAO = new ApartmentDAOimpl();
    //ReservationDAO reservationDAO = new ReservationDAOImpl();

    public void createApartment (int userId, int cityId, ApartType apartType){
        Apartment apartment = new Apartment(userId,cityId,apartType);

    }

    public void creareApartment (Apartment apartment){
        if (!apartment.validation()){
            System.out.println("Apartment : " + apartment.getId() + "Failed validation");
            return;
        }
        try {
            apartmentDAO.addApartment(apartment);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}