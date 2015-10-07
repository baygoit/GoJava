package com.gojava6.airbnb;

import com.gojava6.airbnb.apartment.ApartmentController;
import com.gojava6.airbnb.apartment.ApartmentType;
import com.gojava6.airbnb.apartment.ReservationController;
import com.gojava6.airbnb.application.LoyaltyProgram;
import com.gojava6.airbnb.application.Search;
import com.gojava6.airbnb.users.UserController;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {

        UserController userCon = new UserController();
//        userCon.createUser("Zhuzha", "Ivanovna", "vasya.kuziv@gmail.com", UserType.CLIENT);
//        userCon.deleteUser(19);
//        userCon.updateUserTypeToHost(16);
        userCon.showAllUsers();

        ApartmentController apCon = new ApartmentController();
//        apCon.createApartment("Kiev", ApartmentType.APARTMENT, 21);
//        apCon.createApartment("Kiev", ApartmentType.PLACE, 21);
//        apCon.deleteApartment(16);
        apCon.showAllApartments();

        ReservationController resCon = new ReservationController();
        resCon.createReservation(15, 22, new Date(115, 8, 12), new Date(115, 8, 15));
//        resCon.updateReservationDates(2, new Date(115, 8, 22), new Date(115, 8, 30));
//        resCon.deleteReservation(5);
        resCon.showAllReservations();

        Search search = new Search();
        search.showSearchResults();
        search.filterByCity("Kiev");
        search.showSearchResults();
        search.filterByApartmentType(ApartmentType.ROOM);
        search.showSearchResults();
        search.filterByDates(new Date(115, 8, 1), new Date(115, 8, 4));
        search.showSearchResults();


        //loyalty program
        LoyaltyProgram loyaltyProgram = new LoyaltyProgram();
        loyaltyProgram.setLoyaltyProgramName("New Year loyalty program");
        loyaltyProgram.setAvailable(false);

//        User user1 = userCon.getUser(16);
//        User user2 = userCon.getUser(21);

//        loyaltyProgram.registerObserver(user1);
//        loyaltyProgram.removeObserver(user1);
        loyaltyProgram.notifyObservers();
    }
}
