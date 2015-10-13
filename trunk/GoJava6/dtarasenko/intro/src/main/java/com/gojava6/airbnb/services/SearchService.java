package com.gojava6.airbnb.services;

import com.gojava6.airbnb.model.Apartment;
import com.gojava6.airbnb.model.ApartmentType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class SearchService {

    private List<Apartment> apartmentList;

    public SearchService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        ApartmentService apartmentService = (ApartmentService) context.getBean("apartmentService");
        this.apartmentList = apartmentService.getApartmentList();
    }

    public void showSearchResults() {
        System.out.println("\nSearchService results:");
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
