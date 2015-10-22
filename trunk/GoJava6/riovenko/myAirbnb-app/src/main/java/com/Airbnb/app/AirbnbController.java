package com.Airbnb.app;
import com.Airbnb.app.common.Subject;
import com.Airbnb.app.model.*;
import com.Airbnb.app.services.RegisrationService;
import com.Airbnb.app.services.ReservationService;

import java.util.ArrayList;
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

    public User getUserById (int id){
        return regisrationService.getUserById(id);
    }

    public void createApartment (int hostId, String city, ApartType apartType){
        reservationService.createApartment(hostId, city, apartType);
    }

    public void deleteApartment  (int id) {
        reservationService.deleteApartment(id);
    }

    public Apartment getApartmentById (int id) {
        return reservationService.getApartmentById(id);
    }

    public List<Apartment> getAllApartment (){
        return reservationService.getAllApartment();
    }

    public List<Integer> searchPossibleApartment (String city, ApartType apartType, Date dateFrom, Date dateTo) {
        return reservationService.searchPossibleApartment(city, apartType, dateFrom, dateTo);
    }

    public void makeReservation (int apartmentId, Date dateFrom, Date dateTo) {
        reservationService.makeReservation(apartmentId,dateFrom,dateTo);
    }

    public void notifyAll (String message){
        return;
    }

    public static void main( String[] args ) {

        AirbnbController airbnbController = new AirbnbController();

        // CLIENTS
        /*airbnbController.registerUser("Max", "Mad", "email@gmail.com", false);
        airbnbController.registerUser("Roman","Iovenko","e.m.a.i.l2@gmail.com", false);
        airbnbController.registerUser("Vova", "New", "email3@gmail.com", false);
        airbnbController.registerUser("Sasha", "New-Prime", "email4@gmail.com", false);

        airbnbController.registerUser("Katya", "N-L-P", "email4@gmail.com", false);

        System.out.println("All users :");
        List<User> userList = airbnbController.getAllUsers();
        for (User user : userList){
            System.out.println(user);
        }

        System.out.println("All clients :");
        userList = airbnbController.getAllClients();
        for (User user : userList){
            System.out.println(user);
        }

        System.out.println("Get user by id : " + airbnbController.getUserById(7));

        //airbnbController.removeUser(8);*/

        // HOSTS
        /*airbnbController.registerUser("Andrew", "Ubn-Al-Ka", "email5@gmail.com", true);
        airbnbController.registerUser("Ali","Kuku","email6@gmail.com", true);
        airbnbController.registerUser("Zlatan", "Ibragimovich", "email7@gmail.com", true);
        airbnbController.registerUser("Paveljr", "Sergeev", "email8@gmail.com",true);


        System.out.println("All hosts :");
        userList = airbnbController.getAllHosts();
        for (User user : userList){
            System.out.println(user);
        }
        */

        //APARTMENTS
        /*airbnbController.createApartment(10, "Kyiv", ApartType.ROOM);
        airbnbController.createApartment(11, "Lviv", ApartType.PLACE);
        airbnbController.createApartment(7, "London", ApartType.APARTMENT);
        airbnbController.createApartment(10, "Kyiv", ApartType.PLACE);
        airbnbController.createApartment(10, "Madrid", ApartType.ROOM);

        //airbnbController.deleteApartment(7);

        System.out.println ("Get Aaprtment by id : " + airbnbController.getApartmentById(6));

        System.out.println("All Apartment :");
        List<Apartment> apartmentList = airbnbController.getAllApartment();
        for (Apartment apartment : apartmentList){
            System.out.println(apartment);
        }*/

        // RESERVATION

        Calendar cal = Calendar.getInstance();
        cal.set(2015, Calendar.NOVEMBER, 1);
        java.util.Date dateFrom = cal.getTime();
        Calendar calTo = Calendar.getInstance();
        calTo.set(2015, Calendar.NOVEMBER, 10);
        java.util.Date dateTo = calTo.getTime();

        //airbnbController.makeReservation(4, dateFrom, dateTo);

        List<Integer> arrayList = airbnbController.searchPossibleApartment
                ("Kyiv", ApartType.PLACE, dateFrom, dateTo);
        for (Integer temp : arrayList) {
            System.out.println ("Possible apartment : " + temp);
        }
    }


}
