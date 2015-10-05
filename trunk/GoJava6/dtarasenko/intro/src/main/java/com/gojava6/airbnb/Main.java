package com.gojava6.airbnb;

import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.apartment.ApartmentType;
import com.gojava6.airbnb.application.Application;
import com.gojava6.airbnb.application.LoyaltyProgram;
import com.gojava6.airbnb.application.SearchResult;
import com.gojava6.airbnb.users.User;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Application application = new Application();

        User user1 = new User();
        user1.setName("Nikolay");
        user1.setSurName("Chayka");
        user1.setEmail("nikolay.chayka@gmail.com");

        application.registerUser(user1);

        User user2 = new User();
        user2.setName("Roman");
        user2.setSurName("Solomakha");
        user2.setEmail("roman.solomakha@gmail.com");

        application.registerUser(user2);

        User user3 = new User();
        user3.setName("Vladislav");
        user3.setSurName("Shurubalko");
        user3.setEmail("vladislav.shurubalko@gmail.com");

        application.registerUser(user3);

        user1.becomeHost();
        Apartment apartment1 = new Apartment("Lviv", ApartmentType.ROOM);
        user1.addApartment(apartment1);

        user2.becomeHost();
        Apartment apartment2 = new Apartment("Lviv", ApartmentType.APARTMENT);
        user2.addApartment(apartment2);

        user3.becomeHost();
        Apartment apartment3 = new Apartment("Odessa", ApartmentType.PLACE);
        user3.addApartment(apartment3);





        apartment1.reserve(new Date(115, 8, 10), new Date(115, 8, 15), user2);
        long start = new Date(115, 8, 14).getTime();
        long end = new Date(115, 8, 17).getTime();
        apartment1.isAvailable(start, end);
        apartment1.reserve(new Date(115, 8, 18), new Date(115, 8, 20), user2);
        apartment1.reserve(new Date(115, 8, 22), new Date(115, 8, 26), user2);



        SearchResult searchResult1 = new SearchResult(application.getUserList());
        searchResult1.showSearchResults();
        searchResult1.filterByCity("Lviv");
        searchResult1.showSearchResults();
        searchResult1.filterByApartmentType(ApartmentType.ROOM);
        searchResult1.showSearchResults();
        searchResult1.filterByDates(new Date(115, 8, 21), new Date(115, 8, 25));
        searchResult1.showSearchResults();


        LoyaltyProgram loyaltyProgram = new LoyaltyProgram();
        loyaltyProgram.setLoyaltyProgramName("New Year loyalty program");
        loyaltyProgram.setAvailable(false);

        loyaltyProgram.registerObserver(user2);
        loyaltyProgram.registerObserver(user3);
        loyaltyProgram.removeObserver(user2);
        loyaltyProgram.notifyObservers();
    }
}
