package com.gojava6.airbnb;

import com.gojava6.airbnb.model.ApartmentType;
import com.gojava6.airbnb.model.User;
import com.gojava6.airbnb.services.*;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserService();
//        userService.createUser("Zhena", "Yarokh", "zhena.yarokh@gmail.com", UserType.CLIENT);
        userService.printAllUsers();

        System.out.println();

        ApartmentService apartmentService = new ApartmentService();
//        apartmentService.createApartment("Kiev", ApartmentType.PLACE, 21);
        apartmentService.printAllApartments();

        System.out.println();

        ReservationService reservationService = new ReservationService();
//        reservationService.createReservation(18, 23, new Date(115, 8, 12), new Date(115, 8, 15));
        reservationService.printAllReservations();

        SearchService searchService = new SearchService();
        searchService.showSearchResults();
        searchService.filterByCity("Kiev");
        searchService.showSearchResults();
        searchService.filterByApartmentType(ApartmentType.ROOM);
        searchService.showSearchResults();
        searchService.filterByDates(new Date(115, 8, 1), new Date(115, 8, 4));
        searchService.showSearchResults();


        User user23 = userService.getUser(23);

        LoyaltyProgramService loyaltyProgramService = new LoyaltyProgramService();
        loyaltyProgramService.setLoyaltyProgramName("New Year loyalty program");
//        loyaltyProgramService.registerObserver(user23);
//        loyaltyProgramService.removeObserver(user23);
        loyaltyProgramService.setAvailable(true);


    }
}
