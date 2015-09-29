package com.airbnb;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ����� on 20.09.2015.
 */
public class App {
    private List<Client> clients = new ArrayList<Client>();
    private List<Host> hosts = new ArrayList<Host>();
    private List<Apartment> apartments = new ArrayList<Apartment>();
    private List<Date> reservationDates = new ArrayList<Date>();

//    public void registerClient(Client client) throws Exception {
//
//        clients.add(client);
//        System.out.println("Hello! " + client.getName() + ", you've been registered successfully!");
//    }

    public void register(User user) {
        if (user instanceof Host) {
            hosts.add((Host) user);
        }else{
            clients.add((Client) user);
        }
        System.out.println("Hello! " + user.getName() + ", you've been registered successfully!");
    }

//    public void registerHosts(Host host) throws Exception {
//        hosts.add(host);
//        System.out.println("Hello! " + host.getName() + ", you've been registered successfully!");
//    }

    public List<Client> getClients() {
        for (Client client : clients) {
            System.out.println(client.getName());
        }
        return clients;
    }

    public List<Host> getHosts() {
        for (Host host :hosts) {
            System.out.println(host.getName());
        }
        return hosts;
    }

    public List<Apartment> getApartments() {
//        for (Apartment apartment : apartments) {
//            System.out.println(apartment.getOwnerName());
//        }
        return apartments;
    }

    public List<Date> getReservationDates() {
        for (Date date : reservationDates) {
            date.getPeriod();
        }

        return reservationDates;
    }

    public Apartment createApartment(Apartment.ApartmentType apartmentType, String city, User user ) throws Exception {
        if (hosts.contains(user) == false) {
            throw new Exception();
        }
        Apartment apartment = new Apartment(apartmentType, city, user.getName());
        apartments.add(apartment);
        System.out.println(user.getName() + " is create apartament " + apartmentType);
        return apartment;
    }

    public void makeReservation(User user, Apartment apartment, Date period) throws Exception {
        if (clients.contains(user) == false) {
            throw new Exception("You didn't registered");
        }
        System.out.println("Client " + user.getName() + " reserved apartment successfully! " + apartment.getApartmentType() + " on date: " + period.getDateBegin() + " to " + period.getDateEnd());
        reservationDates.add(period);
    }

    public List<Apartment> searchByOwner(List<Apartment> apartments, User user) throws Exception {
        if (hosts.contains(user) == false){
            throw new Exception("This host doesn't exist!");
        }
        if (apartments.isEmpty()){
            throw new NullPointerException ("No one apartments is available!");
        }

        List<Apartment> newListOfApartments = new ArrayList<Apartment>();
        for (Apartment apartment : apartments) {
            if (apartment.getOwnerName() == user.getName()){
                newListOfApartments.add(apartment);
                System.out.println(user.getName() + " has apartment: " + apartment.getApartmentType());
                //apartments.remove(apartment);
            }
        }

//        for (Apartment apartment : apartments) {
//            System.out.println(user.getName() + " has apartment: " + apartment.getApartmentType());
//        }
        return newListOfApartments;
    }

    public List<Apartment> searchByCity(List<Apartment> apartments, String city) throws Exception {
        if (apartments.isEmpty()){
            throw new NullPointerException ("No one apartments is available!");
        }
        List<Apartment> newListOfApartments = new ArrayList<Apartment>();
        for (Apartment apartment : apartments) {
                if (apartment.getCity() == city){
                    newListOfApartments.add(apartment);
                    //apartments.remove(apartment);
                    System.out.println("In city " + city + " next apartments: " + apartment.getApartmentType());
                }
            }
            return newListOfApartments;
        }

    public boolean IsAvaible(Apartment apartament, Date period) {
        for (Date dates : reservationDates) {
            if (dates.getDateBegin() == period.getDateBegin() || dates.getDateEnd() == dates.getDateEnd()) {
                return false;
            }
        }
        return true;
    }

    public List<Apartment> searchByDate(List<Apartment> apartments, Date period) throws Exception {
        if (apartments.isEmpty()){
            throw new NullPointerException ("No one apartments is available!");
        }
        List<Apartment> newListOfApartments = new ArrayList<Apartment>();
            for (Apartment apartment : apartments) {
                if (IsAvaible(apartment, period) == true){
                    newListOfApartments.add(apartment);
                    System.out.println("On that period " + period.getDateBegin() + " to " + period.getDateEnd() + " next apartaments available:" + apartment.getApartmentType());
                    //apartments.remove(apartment);
                }
            }
        return newListOfApartments;
    }

}