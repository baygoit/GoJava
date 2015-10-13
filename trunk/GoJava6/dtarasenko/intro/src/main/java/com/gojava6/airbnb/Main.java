package com.gojava6.airbnb;

import com.gojava6.airbnb.model.Apartment;
import com.gojava6.airbnb.model.ApartmentType;
import com.gojava6.airbnb.model.Reservation;
import com.gojava6.airbnb.model.User;
import com.gojava6.airbnb.services.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        UserService userService = (UserService) context.getBean("userService");
//        userService.createUser("Zhena", "Yarokh", "zhena.yarokh@gmail.com", UserType.CLIENT);
//        User user = userService.getUser(26);
//        userService.deleteUser(user);
//        userService.updateUserTypeToHost(user);
        userService.printAllUsers();

        System.out.println();

        ApartmentService apartmentService = (ApartmentService) context.getBean("apartmentService");
//        apartmentService.createApartment("London", ApartmentType.APARTMENT, 23);
//        Apartment apartment = apartmentService.getApartment(29);
//        apartmentService.deleteApartment(apartment);
        apartmentService.printAllApartments();

        System.out.println();

        ReservationService reservationService = (ReservationService) context.getBean("reservationService");
//        reservationService.createReservation(28, 23, new Date(115, 8, 5), new Date(115, 8, 15));
//        Reservation reservation = reservationService.getReservation(21);
//        reservationService.deleteReservation(reservation);
//        reservationService.updateReservationDates(21, new Date(115, 8, 1), new Date(115, 8, 3));
        reservationService.printAllReservations();

        SearchService searchService = new SearchService();
        searchService.showSearchResults();
        searchService.filterByCity("Kiev");
        searchService.showSearchResults();
        searchService.filterByApartmentType(ApartmentType.ROOM);
        searchService.showSearchResults();
        searchService.filterByDates(new Date(115, 8, 1), new Date(115, 8, 4));
        searchService.showSearchResults();


        User user16 = userService.getUser(16);

        LoyaltyProgramService loyaltyProgramService = (LoyaltyProgramService) context.getBean("loyaltyProgramService");
        loyaltyProgramService.setLoyaltyProgramName("New Year loyalty program");
//        loyaltyProgramService.registerObserver(user26);
        loyaltyProgramService.removeObserver(user16);
        loyaltyProgramService.setAvailable(true);



    }
}
