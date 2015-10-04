package com.airbnb.user;

import com.airbnb.apartment.*;
import com.airbnb.observer.*;
import com.airbnb.system.AirBnBSystem;
import com.airbnb.system.Log;
import static com.airbnb.system.Validation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 19.09.15.
 */
public class User implements Observer {

    private String name;
    private String surname;
    private String email;
    private String city;
    private UserType userType;
    private boolean isRegisteredAsClient;
    private boolean isRegisteredAsHost;

    private Map<Integer, Apartment> listOfApartments = new HashMap<Integer, Apartment>();

    //  constructor for CLIENT
    public User(String name, String surname, String email) {
        this.userType = UserType.CLIENT;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public boolean isRegisteredAsHost() {
        return isRegisteredAsHost;
    }

    public void setIsRegisteredAsHost(boolean isRegisteredAsHost) {
        this.isRegisteredAsHost = isRegisteredAsHost;
    }

    public boolean isRegisteredAsClient() {
        return isRegisteredAsClient;
    }

    public void setIsRegisteredAsClient(boolean isRegisteredAsClient) {
        this.isRegisteredAsClient = isRegisteredAsClient;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Map<Integer, Apartment> getListOfApartments() {
        return listOfApartments;
    }

    public void setListOfApartments(Map<Integer, Apartment> listOfApartments) {
        this.listOfApartments = listOfApartments;
    }

    public void addApartment(Integer idApartment, Apartment apartment) {
        listOfApartments.put(idApartment, apartment);
    }

    public void removeApartment(Integer idApartment) {
        listOfApartments.remove(idApartment);
    }

    public void update(String s) {
        System.out.println(s);
    }

    public Apartment getApartment(Integer idApartment) {
        return listOfApartments.get(idApartment);
    }

    public void becomeHost(AirBnBSystem aS, String city, Integer idApartment, ApartmentType apartmentType,
                           LocalDate start, LocalDate end) {

        if (isRegisteredAsClient() &&
                isValidName(city) &&
                isValidApartmentType(apartmentType) &&
                isValidDate(start, end)) {
            setUserType(UserType.HOST);
            setIsRegisteredAsHost(true);
            setCity(city);
            Apartment apartment = new Apartment(apartmentType, start, end);
            addApartment(idApartment, apartment);
            aS.addCity(this);
            Log.logger.info(" -- " + getName() + " " + getSurname() + " became HOST!");
        }

        else {
            Log.logger.info(" -- " + getName() + " " + getSurname() + " FAILED becoming HOST :(");
        }
    }

    public void registerApartment(Integer idApartment, ApartmentType apartmentType,
                                  LocalDate start, LocalDate end) {

        Apartment apartment = new Apartment(apartmentType, start, end);
        addApartment(idApartment, apartment);
        Log.logger.info("New apartment in " + getCity() + " by " + getSurname() +
                " was registered");
    }
}