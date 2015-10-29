package main.java.Models;

import main.java.Subject;
import main.java.Observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @autor A_Nakonechnyi
 * @date 26.09.2015.
 */
public class Apartment implements Subject {
    private int apartmentId;
    //public enum ApartmentType {PLACE , ROOM, APARTMENT};
    public ApartmentType apartmentType;
    //private Date endOfRent;
    private LinkedList<Reservation> reservationList;
    public static String city;
    public int host;
    private List<Observer> listOfClients = new ArrayList<Observer>();
    //public String switchedApartType;
    public Apartment(int apartmentId, int userHost, ApartmentType type,  String city) {
        this.apartmentId=apartmentId;
        this.apartmentType=type;
        this.host=userHost;
        this.city=city;
    }
    /*public static ApartmentType valueOf (String apartTypeStr) {
        if (apartTypeStr.equals("PLACE")){return ApartmentType.PLACE;}
        if (apartTypeStr.equals("ROOM")){return ApartmentType.ROOM;}
        if (apartTypeStr.equals("APARTMENT")){return ApartmentType.APARTMENT;}
        System.out.println("Incorrect apartment type!!!");
        return null;
    }*/
//    @Override
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

    public int getApartmentId() {
        return apartmentId;
    }

    public Boolean cancelReservation (int clientId, Reservation reservation) {
        if (reservation.idClientChecker(clientId)) {
            reservationList.remove(reservationList.indexOf(reservation));
            return  true;
        } else return false;
    }
}
