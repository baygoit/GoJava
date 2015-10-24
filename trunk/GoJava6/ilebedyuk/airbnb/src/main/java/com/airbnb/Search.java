package com.airbnb;

import com.airbnb.model.Apartment;
import com.airbnb.services.ReservationDatesService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Игорь on 05.10.2015.
 */
public class Search {
    List<Apartment> newListOfApartments = new ArrayList<Apartment>();

    public List<Apartment> searchByOwner(List<Apartment> apartments, int userId) {
        for (Apartment apartment : apartments) {
            if (apartment.getOwnerId() == userId){
                newListOfApartments.add(apartment);
            }
        }
        return newListOfApartments;
    }

    public List<Apartment> searchByCity(List<Apartment> apartments, String city) {
        for (Apartment apartment : apartments) {
            if (apartment.getCity().equals(city)){
                newListOfApartments.add(apartment);
            }
        }
        return newListOfApartments;
    }

    public List<Apartment> searchByDate(List<Apartment> apartments, ReservationDatesService reservationDatesService, long dateStart, long dateFinish) {
        for (Apartment apartment : apartments) {
            if (reservationDatesService.isAvailableApartment(apartment.getIdAparnament(), dateStart, dateFinish) == true){
                newListOfApartments.add(apartment);
            }
        }
        return newListOfApartments;
    }

    public void printSearchedApartments(List<Apartment> newListOfApartments){
        for (Apartment apartment : newListOfApartments) {
            System.out.println(apartment.toString());
        }
    }
}
