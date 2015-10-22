package com.airbnb.model;

import com.airbnb.services.Validator;
import org.apache.log4j.Logger;

/**
 * Created by Игорь on 20.09.2015.
 */
public class User implements com.airbnb.observer.Observer {
    private String Name;
    private String Surname;
    private String Email;
    private int userId;
    private String userType;
    private String city;
    private static final Logger log = Logger.getLogger(User.class);

    public User(String name, String surname, String email, String city, String userType) {
        this.Name = name;
        this.Surname = surname;
        this.Email = email;
        this.userType = userType;
        this.city = city;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    public void makeReservation(Apartment apartment, ReservationDate reservationDate) throws Exception {
//        if (apartment.isAvaible(reservationDate) == false || apartment.getOwnerName() == getName()){
//            log.info("Error");
//            throw new Exception("Apartments already reserved!");
//        }
//        if (Application.getUser().contains(this) == false){
//            throw new Exception("You're not registered!");
//        }
//        System.out.println("Client " + getName() + " reserved apartment successfully! " + apartment.getApartmentType() + " on date: " + reservationDate.getDateBegin() + " to " + reservationDate.getDateEnd());
//        apartment.getReservationDates().put(reservationDate, apartment);
//        log.info("Reservation complete!");
//    }

//    public Apartment addApartment(Apartment.ApartmentType apartmentType, String city) throws Exception {
//        if (Application.getUser().contains(this) == false){
//            throw new Exception("You're not registered!");
//        }
//        if (this.userType == userType.Host){
//            Apartment apartment = new Apartment(apartmentType, city, getName());
//            apartments.add(apartment);
//            Search.getAllApartments().add(apartment);
//            System.out.println(getName() + " is create apartament " + apartmentType);
//            log.info("Apartments already created!");
//            return apartment;
//        } else throw new Exception("You aren't Host");
//    }

    public void setName(String name) throws Exception {
        Name = name;
    }

    public void setSurname(String surname) throws Exception {
        Surname = surname;
    }

    public void setEmail(String email) throws Exception {
        Email = email;
    }

    public String getUserType() {
        return userType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws Exception {
        this.city = city;
    }

    public String getName() {
        return Name;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSurname() {
        return Surname;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public void update(String news) {
        System.out.println("Hello! " + Name + ", today next news: " + news);
    }

    @Override
    public String toString() {
        return "Id: '" + this.userId +
                "', Name: '" + this.Name +
                "', Surname: '" + this.Surname +
                "', Email: '" + this.Email +
                "', City: '" + this.city +
                "', UserType: '" + this.userType + "'";
    }

}