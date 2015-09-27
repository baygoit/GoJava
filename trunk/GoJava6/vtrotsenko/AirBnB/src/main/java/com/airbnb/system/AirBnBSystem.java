package com.airbnb.system;

import com.airbnb.observer.*;
import com.airbnb.user.*;
import com.airbnb.apartment.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by root on 19.09.15.
 */
public class AirBnBSystem implements SystemInterface {

    private Set<Observer> listOfObservers = new HashSet<Observer>();    // hashset of ALL types Users
    private Set<String> listofCities = new HashSet<String>();           //list of cities

    public AirBnBSystem() {
        Log.setFileHandler();
    }

    public Set<Observer> getListOfObservers() {
        return listOfObservers;
    }

    public void setListOfObservers(Set<Observer> listOfObservers) {
        this.listOfObservers = listOfObservers;
    }

    public Set<String> getListofCities() {
        return listofCities;
    }

    public void setListofCities(Set<String> listofCities) {
        this.listofCities = listofCities;
    }

    public void registerObserver(Observer o) {
        listOfObservers.add(o);
    }

    public void removeObserver(Observer o) {
        listOfObservers.remove(o);
    }

    // here we notify all observers
    public void notifyAllObservers(String cityName) {
        for(Observer observer : listOfObservers) {
            //observer.update("The new city was added " + cityName);
            Log.logger.info(observer.getName() + " " + observer.getSurname() + " was notified that city " +
                    cityName + " was added.");
        }
    }

    public void registerHost(Host host) {

        if(validateName(host.getName()) && validateName(host.getSurname()) && validateEmail(host.getEmail())
                && validateName(host.getCity()) && validateApartmentType(host.getApartment().getApartmentType())
                && validateDate(host.getApartment().getFirstDayAvailable(), host.getApartment().getLastDayAvailable())) {
            addCity(host);
            listofCities.add(host.getCity());
            Log.logger.info(" -- " + host.getName() + " " + host.getSurname() + " was registered as CLIENT");
        }
        else {
            Log.logger.info(" -- " + host.getName() + " " + host.getSurname() + " FAILED registration as HOST");
        }
    }

    public void registerClient(Client client) {

        if(validateName(client.getName()) && validateName(client.getSurname()) && validateEmail(client.getEmail())) {
            listOfObservers.add(client);
            //System.out.println(client.getName() + " was sucsessfully registered as CLIENT.");
            Log.logger.info(" -- " + client.getName() + " " + client.getSurname() + " was registered as CLIENT");
        }
        else {
            Log.logger.info(" -- " + client.getName() + " " + client.getSurname() + " FAILED registration as CLIENT");
        }
    }

    //TODO: validate dates in better way

    public void makeReservation(Observer observer, Host host, LocalDate startDate, LocalDate endDate) {
        if (validateDate(startDate, endDate) && validateReservationDate(host.getApartment(), startDate, endDate)
                && host.getApartment().isAvailable()) {
            host.update("User " + observer.getName() + " " + observer.getSurname() + " wants to book " +
                     host.getName() + " " + host.getSurname() + "'s apartment from " + startDate + " to " +
                     endDate + ". Connect him " + observer.getEmail());
            host.getApartment().updateAvailableDate(startDate, endDate);
        }
    }

    private void addCity(Host host) {
        registerObserver(host);
        if (!getListofCities().contains(host.getCity())) {
            notifyAllObservers(host.getCity());
        }
    }

    // ------------------------------- VALIDATION --------------------------------------------

    private boolean validateName(String name) {

        if(name != null && !consistDigits(name))
            return true;

        else {
            System.out.println("Invalid name " + name);
            Log.logger.warning("Validation of name/surname failed!");
            return false;
        }
    }

    // TODO : Add InternetAdress class to validate email better
    private boolean validateEmail(String email) {

        if(email != null && email.contains("@gmail.com"))
            return true;

        else {
            System.out.println("Invalid email " + email);
            Log.logger.warning("Validation of email failed!");
            return false;
        }
    }

    private boolean validateApartmentType(ApartmentType apartmentType) {

        ApartmentType[] apartmentTypes = ApartmentType.values();
        for (ApartmentType apartmentType1 : apartmentTypes) {
            if (apartmentType.equals(apartmentType1))
                return true;
        }
        Log.logger.warning("Validation of reservation ApartmentType failed!");
        return false;
    }

    private boolean validateDate(LocalDate startDate, LocalDate endDate) {
        if (startDate.compareTo(endDate) > 0) {
            System.out.println("Invalid date period!");
            Log.logger.warning("Validation of date failed!");
            return false;
        }
        return true;
    }

    private boolean validateReservationDate(Apartment apartment, LocalDate startDate, LocalDate endDate) {
        if ( (startDate.compareTo(apartment.getFirstDayAvailable()) < 0) ||
                (endDate.compareTo(apartment.getLastDayAvailable()) > 0) ) {
            Log.logger.warning("Validation of reservation date failed!");
            return false;
        }
        return true;
    }

    // method to check whether some string consist Numbers or not
    private boolean consistDigits(String str) {

        if(str.contains("[a-zA-Z]+"))
            return true;

        else
            return false;
    }
}