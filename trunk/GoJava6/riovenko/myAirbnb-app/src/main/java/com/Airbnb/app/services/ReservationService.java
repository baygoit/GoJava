package com.Airbnb.app.services;

import com.Airbnb.app.DAO.ApartmentDAO;
import com.Airbnb.app.DAO.ApartmentDAOimpl;
import com.Airbnb.app.DAO.ReservationDAO;
import com.Airbnb.app.DAO.ReservationDAOImpl;
import com.Airbnb.app.model.ApartType;
import com.Airbnb.app.model.Apartment;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by romanroma on 18.10.15.
 */
public class ReservationService {
    ApartmentDAO apartmentDAO = new ApartmentDAOimpl();
    ReservationDAO reservationDAO = new ReservationDAOImpl();
    private int cityId;

    public void createApartment (int userId, String city, ApartType apartType){
        try {
            cityId = apartmentDAO.checkUniqueCity(city);
        } catch (SQLException e){
            e.printStackTrace();
        }

        try {
            if (apartmentDAO.checkExistingApartment (userId, city, apartType) == 1){
                System.out.println ("Apartment : " + userId + " " + city + " " + apartType + " is already exist");
                return;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        Apartment apartment = new Apartment (userId, city, apartType);
        createApartment(apartment);
    }

    public void createApartment (Apartment apartment){
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

    public void deleteApartment (int id){
        try{
            apartmentDAO.deleteApartment(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Apartment> getAllAprtment (){
        List<Apartment> apartmentList = new LinkedList<>();
        try{
            apartmentList = apartmentDAO.getAllApartment();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return apartmentList;
    }

    public Apartment getApartmentById (int id){
        try{
            return apartmentDAO.getApartmentById(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void makeReservation (int apartmentId, Date dateFrom, Date dateTo){
        try{
            reservationDAO.makeReservation(apartmentId,dateFrom,dateTo);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}