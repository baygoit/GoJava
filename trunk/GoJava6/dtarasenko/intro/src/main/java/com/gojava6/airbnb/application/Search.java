package com.gojava6.airbnb.application;

import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.apartment.ApartmentController;
import com.gojava6.airbnb.apartment.ApartmentType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Search {

    private List<Apartment> apartmentList;

    public Search() {
        ApartmentController apartmentController = new ApartmentController();
        this.apartmentList = apartmentController.getApartmentList();
    }

    public void showSearchResults() {
        System.out.println("\nSearch results:");
        for (Apartment apartment : apartmentList) {
            System.out.println(apartment.toString());
        }
    }

    public void filterByCity(String city) {
        List<Apartment> list = new ArrayList<Apartment>();
        for (Apartment apartment : apartmentList) {
            if (apartment.getCity().equals(city)) {
                list.add(apartment);
            }
        }
        apartmentList = list;
    }

    public void filterByApartmentType(ApartmentType apartmentType) {
        List<Apartment> list = new ArrayList<Apartment>();
        for (Apartment apartment : apartmentList) {
            if (apartment.getApartmentType().equals(apartmentType.getApartmentType())) {
                list.add(apartment);
            }
        }
        apartmentList = list;
    }

    public void filterByDates(Date startDate, Date endDate){
        long start = startDate.getTime();
        long end = endDate.getTime();

        List<Apartment> list = new ArrayList<Apartment>();

        for (Apartment apartment : apartmentList) {
            if (apartment.isAvailable(start, end)) {
                list.add(apartment);
            }
        }
        apartmentList = list;
    }

}
