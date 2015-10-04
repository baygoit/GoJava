package com.airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Игорь on 05.10.2015.
 */
public class Search {

    private static List<Apartment> AllApartments = new ArrayList<Apartment>();

    public static List<Apartment> getAllApartments() {
        return AllApartments;
    }

    public List<Apartment> searchByOwner(List<Apartment> apartments, User user) throws Exception {
        if (apartments.isEmpty()){
            throw new NullPointerException ("No one apartments is available!");
        }
        List<Apartment> newListOfApartments = new ArrayList<Apartment>();
        for (Apartment apartment : apartments) {
            if (apartment.getOwnerName() == user.getName()){
                newListOfApartments.add(apartment);
                System.out.println(user.getName() + " has apartment: " + apartment.getApartmentType());
            }
        }
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
                System.out.println("In city " + city + " next apartments: " + apartment.getApartmentType());
            }
        }
        return newListOfApartments;
    }

    public List<Apartment> searchByDate(List<Apartment> apartments, ReservationDate period) throws Exception {
        if (apartments.isEmpty()){
            throw new NullPointerException ("No one apartments is available!");
        }
        List<Apartment> newListOfApartments = new ArrayList<Apartment>();
        for (Apartment apartment : apartments) {
            if (apartment.isAvaible(period) == true){
                newListOfApartments.add(apartment);
                System.out.println("On that period " + period.getDateBegin() + " to " + period.getDateEnd() + " next apartaments available:" + apartment.getApartmentType());
            }
        }
        return newListOfApartments;
    }
}
