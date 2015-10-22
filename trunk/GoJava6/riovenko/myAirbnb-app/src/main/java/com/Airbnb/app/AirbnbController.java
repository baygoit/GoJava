package com.Airbnb.app;
import com.Airbnb.app.common.Subject;
import com.Airbnb.app.model.*;
import com.Airbnb.app.services.RegisrationService;
import com.Airbnb.app.services.ReservationService;

import java.util.Date;
import java.util.List;
import java.util.Calendar;

/**
 * Created by romanroma on 26.09.15.
 */

public class AirbnbController implements Subject {

    private RegisrationService regisrationService = new RegisrationService();
    private ReservationService reservationService = new ReservationService();

    public void registerUser (String name, String surname, String email, Boolean isHost){
        regisrationService.register(name, surname, email, isHost);
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

    public void createApartment (int hostId, String city, ApartType apartType){
        reservationService.createApartment(hostId, city, apartType);
    }

    public void makeReservation (int apartmentId, Date dateFrom, Date dateTo){
        reservationService.makeReservation(apartmentId,dateFrom,dateTo);
    }

    public void notifyAll (String message){
        return;
    }

    public static void main( String[] args ) {

        AirbnbController airbnbController = new AirbnbController();

        //airbnbController.registerUser("Max", "Mad", "email@gmail.com",false);
        //airbnbController.registerUser("Roman","Iovenko","email2@gmail.com",false);
        //airbnbController.registerUser("Vova", "New", "email3@gmail.com", true);
        //airbnbController.registerUser("Sasha", "Prime", "email4@gmail.com",true);
        //airbnbController.createApartment(3, "Kyiv", ApartType.ROOM);
        Calendar cal = Calendar.getInstance();
        cal.set(2015, Calendar.NOVEMBER, 1);
        java.util.Date dateFrom = cal.getTime();
        Calendar calTo = Calendar.getInstance();
        calTo.set(2015, Calendar.NOVEMBER, 10);
        java.util.Date dateTo = calTo.getTime();
        airbnbController.makeReservation(2, dateFrom, dateTo);
        //airbnbController.notifyAll("Done");
        //airbnbController.removeUser(1);

    }


}
