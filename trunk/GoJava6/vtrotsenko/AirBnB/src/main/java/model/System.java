package model;

import observer.Observer;
import observer.SystemInterface;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static validation.Validation.*;

/**
 * Created by root on 04.11.15.
 */
public class System implements SystemInterface {

    private Set<Observer> listOfObservers = new HashSet<Observer>();       // hashset of ALL types Users
    private Set<String> listofCities = new HashSet<String>();            // list of cities

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

    // notification
    public void notifyAllObservers(String cityName) {
        for(Observer observer : listOfObservers) {
        }
    }

    public void makeReservation(User client, User host, Integer idApartment,
                                LocalDate startDate, LocalDate endDate) {
        if (isValidDate(startDate, endDate) &&
                isValidReservationDate(host.getApartment(idApartment), startDate, endDate) &&
                host.getApartment(idApartment).isAvailable()) {
            host.update("User " + client.getName() + " " + client.getLastname() + " wants to book " +
                    host.getName() + " " + host.getLastname() + "'s apartment from " + startDate + " to " +
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
