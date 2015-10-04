package com.airbnb.system;

import com.airbnb.observer.*;
import com.airbnb.user.*;
import static com.airbnb.system.Validation.*;

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
            Log.logger.info(observer.getName() + " " + observer.getSurname() + " was notified that city " +
                    cityName + " was added.");
        }
    }

    public void registerUser(User user) {

        if (user.getUserType().equals(UserType.CLIENT) &&
                isValidName(user.getName()) &&
                isValidName(user.getSurname()) &&
                isValidEmail(user.getEmail())) {

            registerObserver(user);
            user.setIsRegisteredAsClient(true);
            Log.logger.info(" -- " + user.getName() + " " + user.getSurname() + " was registered!");
        }

        else {
            Log.logger.info(" -- " + user.getName() + " " + user.getSurname() + " FAILED registration :(");
        }
    }

    public void makeReservation(User client, User host, Integer idApartment,
                                LocalDate startDate, LocalDate endDate) {
        if (isValidDate(startDate, endDate) &&
                isValidReservationDate(host.getApartment(idApartment), startDate, endDate) &&
                host.getApartment(idApartment).isAvailable()) {
            host.update("User " + client.getName() + " " + client.getSurname() + " wants to book " +
                    host.getName() + " " + host.getSurname() + "'s apartment from " + startDate + " to " +
                    endDate + ". Connect him " + client.getEmail());
            host.getApartment(idApartment).updateAvailableDate(startDate, endDate);
        }
    }

    public void addCity(User user) {
        if (!getListofCities().contains(user.getCity())) {
            notifyAllObservers(user.getCity());
        }
    }

}