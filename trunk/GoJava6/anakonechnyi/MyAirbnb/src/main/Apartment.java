package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 26.09.2015.
 */
public class Apartment implements Subject{
    public enum ApartmentType {PLACE , ROOM, APARTMENT};
    public ApartmentType apartmentType;
    //private Date endOfRent;
    private LinkedList<Reservation> reservationList;
    public static String city;
    public User host;
    private List<Observer> listOfClients = new ArrayList<Observer>();
    //public String switchedApartType;
    public Apartment(ApartmentType type, User userHost, String city) {
        this.apartmentType=type;
        this.host=userHost;
        this.city=city;
    }

 //   @Override
    public void registerObserver(Observer o) {
        System.out.println("Register: " + o.toString());
        listOfClients.add(o);
        o.loyalty(10, this);
    }

//    @Override
    public void removeObserver(Observer o) {
        System.out.println("Remove: "+o.toString());
        listOfClients.remove(o);
    }

//    @Override
    public void notifyObservers() {
        System.out.println("Notify Observers");
        for (Observer obs :listOfClients) {
            obs.update(this);//this host
        }
    }
    public String getCity() {
        return city;
    }

    /*public Date getEndDate() {
        return endOfRent;
    }*/
    public Boolean isAvailable(Date dateToCheck){
        for (Reservation res : reservationList) {
            if (res.getStart().compareTo(dateToCheck) < 1 &&
                    res.getFinish().compareTo(dateToCheck) > -1) {
                return false;
            }
        }
        return true;
    }

    public Boolean cancelReservation (int clientId, Reservation reservation) {
        if (reservation.idClientChecker(clientId)) {
            reservationList.remove(reservationList.indexOf(reservation));
            return  true;
        } else return false;
    }
}
