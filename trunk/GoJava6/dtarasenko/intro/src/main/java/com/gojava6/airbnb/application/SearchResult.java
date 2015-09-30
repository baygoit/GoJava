package com.gojava6.airbnb.application;

import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.apartment.ReservationData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchResult {

    private List<Apartment> listOfApartments;
    private List<ReservationData> listOfReservedDates;

    public SearchResult(Application app) {
        this.listOfApartments = new ArrayList<Apartment>(app.getListOfApartments());
        this.listOfReservedDates = new ArrayList<ReservationData>(app.getListOfReservedDates());
    }

    public void showSearchResults() {
        System.out.print("\nSearchResult results:");
        for (Apartment apartment : listOfApartments) {
            System.out.print("\nApartment ID: " + apartment.getApartmentId());
            System.out.print(", Host ID: " + apartment.getUserId());
            System.out.print(", City: " + apartment.getCity());
            System.out.print(", Apartment type: " + apartment.getApartmentType() + ".");
        }
        System.out.println();
    }

    public void filterByCity(String city) {
        List<Apartment> list = new ArrayList<Apartment>();
        for (Apartment apartment : listOfApartments) {
            if (apartment.getCity().equals(city)) {
                list.add(apartment);
            }
        }
        listOfApartments = list;
    }

    public void filterByApartmentType(String apartmentType) {
        List<Apartment> list = new ArrayList<Apartment>();
        for (Apartment apartment : listOfApartments) {
            if (apartment.getApartmentType().equals(apartmentType)) {
                list.add(apartment);
            }
        }
        listOfApartments = list;
    }

    public void filterByDates(Date startDate, Date endDate){
        long start = startDate.getTime();
        long end = endDate.getTime();
        List<Apartment> list = new ArrayList<Apartment>();

        for (Apartment ap : listOfApartments) {
            if (isAvailable(ap.getApartmentId(),start, end)) {
                list.add(ap);
            }
        }
        listOfApartments = list;
    }

    private boolean isAvailable(int apartmentId, long start, long end) {
        for (ReservationData rd : listOfReservedDates) {
            if (rd.getApartmentId() == apartmentId) {
                if ((end < rd.getStart() || start > rd.getEnd())) {
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
