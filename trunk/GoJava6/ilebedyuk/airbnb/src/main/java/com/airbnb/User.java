package com.airbnb;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.*;
import org.apache.log4j.Logger;

/**
 * Created by Игорь on 20.09.2015.
 */
public class User implements Observer{
    private String Name;
    private String Surname;
    private String Email;
    enum UserType {Client, Host};
    private UserType userType;
    private List<Apartment> apartments = new ArrayList<Apartment>();
    private String city;
    private static final Logger log = Logger.getLogger(User.class);


    public User(String name, String surname, String email) throws Exception {
        if (validateUserData(name) == true && validateUserData(surname) == true && validateEmail(email) == true) {
            this.Name = name;
            this.Surname = surname;
            this.Email = email;
            this.userType = userType.Client;
            this.city = null;
        } else throw new Exception();
    }

    public User(String name, String surname, String email, String city) throws Exception {
        if (validateUserData(name) == true && validateUserData(surname) == true && validateEmail(email) == true && validateUserData(city) == true) {
            this.Name = name;
            this.Surname = surname;
            this.Email = email;
            this.userType = userType.Host;
            this.city = city;
        } else throw new Exception();
    }

    public void becomeHost(String city) throws Exception {
        if (validateUserData(city) == true){
            this.city = city;
            this.userType = userType.Host;
        }
        else throw new Exception();
    }

    public void makeReservation(Apartment apartment, ReservationDate reservationDate) throws Exception {
        if (apartment.isAvaible(reservationDate) == false || apartment.getOwnerName() == getName()){
            log.info("Error");
            throw new Exception("Apartments already reserved!");
        }
        if (Application.getUser().contains(this) == false){
            throw new Exception("You're not registered!");
        }
        System.out.println("Client " + getName() + " reserved apartment successfully! " + apartment.getApartmentType() + " on date: " + reservationDate.getDateBegin() + " to " + reservationDate.getDateEnd());
        apartment.getReservationDates().put(reservationDate, apartment);
        log.info("Reservation complete!");
    }

    public Apartment createApartment(Apartment.ApartmentType apartmentType, String city) throws Exception {
        if (Application.getUser().contains(this) == false){
            throw new Exception("You're not registered!");
        }
        if (this.userType == userType.Host){
            Apartment apartment = new Apartment(apartmentType, city, getName());
            apartments.add(apartment);
            Search.getAllApartments().add(apartment);
            System.out.println(getName() + " is create apartament " + apartmentType);
            log.info("Apartments already created!");
            return apartment;
        } else throw new Exception("You aren't Host");

    }

    private boolean validateUserData(String name) {
        if (name == null || name.isEmpty() || isAlpha(name) == false){
            return false;
        }
        return true;
    }

    private boolean validateEmail(String email) {
        if (isValidEmailAddress(email) == false || email == null || email.isEmpty()){
            return false;
        }
        return true;
    }

    public void setName(String name) throws Exception {
        if (validateUserData(name) == true){
            Name = name;
        } else throw new Exception();

    }

    public void setSurname(String surname) throws Exception {
        if (validateUserData(surname) == true){
            Surname = surname;
        }else throw new Exception();
    }

    public void setEmail(String email) throws Exception {
        if (validateEmail(email) == true){
            Email = email;
        } else throw new Exception();

    }

    public UserType getUserType() {
        return userType;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws Exception {
        if (validateUserData(city) == true){
            this.city = city;
        } else throw new Exception();

    }

    private boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if (!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }

    private boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public String getName() {
        return Name;
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

}