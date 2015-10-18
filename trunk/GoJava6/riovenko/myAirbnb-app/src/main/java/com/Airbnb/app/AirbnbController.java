package com.Airbnb.app;
import com.Airbnb.app.DAO.ApartmentDAOimpl;
import com.Airbnb.app.DAO.UserDAOimpl;
import com.Airbnb.app.model.Apartment;
import com.Airbnb.app.common.Observer;
import com.Airbnb.app.common.Subject;
import com.Airbnb.app.model.*;
import com.Airbnb.app.Maps;
import com.Airbnb.app.DAO.UserDAO;
import com.Airbnb.app.DAO.ApartmentDAO;
import com.Airbnb.app.services.RegisrationService;
import com.Airbnb.app.services.ReservationService;

import java.util.*;
import java.util.List;

/**
 * Created by romanroma on 26.09.15.
 */

public class AirbnbController implements Subject {

    private RegisrationService regisrationService = new RegisrationService();
    private ReservationService reservationService = new ReservationService();

    public void registerUser (String name, String surname, String email, Boolean isHost){
        regisrationService.registration(name, surname, email, isHost);
    }

    public void removeUser (int id){
        regisrationService.deleteUser(id);
    }

    public List getAllUsers(){
        return regisrationService.getAllUsers();
    }

    public List getAllClients(){
        return regisrationService.getAllClients();
    }

    public List getAllHosts(){
        return regisrationService.getAllHosts();
    }

    public void createApartment (int hostId, int cityId, ApartType apartType){
        reservationService.createApartment(hostId, cityId, apartType);
    }

    public void notifyAll (String message){
        return;
    }

    public static void main( String[] args ) {

        AirbnbController airbnbController = new AirbnbController();

        airbnbController.registerUser("Max", "Mad", "email@gmail.com",false);
        //airbnbController.registerUser("Roman","Iovenko","email2@gmail.com",false);
        //airbnbController.registerUser("Vova", "New", "email3@gmail.com",true);
        //airbnbController.registerUser("Sasha", "Prime", "email4@gmail.com",true);
        //airbnbController.createApartment(1, "Kyiv", ApartType.ROOM, false);
        //airbnbController.notifyAll("Done");
        //airbnbController.removeUser(1);

    }


}
