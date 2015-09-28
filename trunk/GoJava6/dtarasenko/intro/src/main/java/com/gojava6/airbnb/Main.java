package com.gojava6.airbnb;

import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.apartment.ApartmentBuilder;
import com.gojava6.airbnb.apartment.ApartmentType;
import com.gojava6.airbnb.apartment.ReservationData;
import com.gojava6.airbnb.application.Application;
import com.gojava6.airbnb.application.LoyaltyProgram;
import com.gojava6.airbnb.application.SearchResult;
import com.gojava6.airbnb.users.Client;
import com.gojava6.airbnb.users.Host;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception{


        //create application
        Application app = new Application();

        //host creation and registration
        Host host1 = new Host();
        host1.setName("Nikolay");
        host1.setSurName("Chayka");
        host1.setEmail("nikolay.chayka@gmail.com");
        app.registerUser(host1);






        //create client and registration
        Client client1 = new Client();
        client1.setName("Roman");
        client1.setSurName("Solomakha");
        client1.setEmail("roman.solomakha@gmail.com");
        app.registerUser(client1);

        Client client2 = new Client();
        client2.setName("Vladislav");
        client2.setSurName("Shurubalko");
        client2.setEmail("vladislav.shurubalko@gmail.com");
        app.registerUser(client2);









        //apartment creation and adding to host
        ApartmentBuilder apartBuilder1 = new ApartmentBuilder();
        apartBuilder1.setUser(host1);
        apartBuilder1.setCity("Kiev");
        apartBuilder1.setApartmentType(ApartmentType.PLACE);
        Apartment apartment1 = apartBuilder1.createApartment();
        app.addApartment(apartment1);

        ApartmentBuilder apartBuilder2 = new ApartmentBuilder();
        apartBuilder2.setUser(host1);
        apartBuilder2.setCity("Lviv");
        apartBuilder2.setApartmentType(ApartmentType.ROOM);
        Apartment apartment2 = apartBuilder2.createApartment();
        app.addApartment(apartment2);

        ApartmentBuilder apartBuilder3 = new ApartmentBuilder();
        apartBuilder3.setUser(host1);
        apartBuilder3.setCity("Odessa");
        apartBuilder3.setApartmentType(ApartmentType.APARTMENT);
        Apartment apartment3 = apartBuilder3.createApartment();
        app.addApartment(apartment3);

        ApartmentBuilder apartBuilder4 = new ApartmentBuilder();
        apartBuilder4.setUser(host1);
        apartBuilder4.setCity("Lviv");
        apartBuilder4.setApartmentType(ApartmentType.APARTMENT);
        Apartment apartment4 = apartBuilder4.createApartment();
        app.addApartment(apartment4);

        //searchResult apartment
        SearchResult sr = new SearchResult(app);
        sr.showSearchResults();
        sr.filterByCity("Lviv");
        sr.showSearchResults();
        sr.filterByApartmentType("Apartment");
        sr.showSearchResults();

        //reserveApartment
        app.reserveApartment(4, client1, new Date(115, 8, 10), new Date(115, 8, 15));
        app.reserveApartment(4, client1, new Date(115, 8, 20), new Date(115, 8, 25));

        System.out.print("\nReservation list:");
        for (ReservationData rd : app.getListOfReservedDates()) {
            System.out.print("\nApartment ID: " + rd.getApartmentId());
            System.out.print(", User ID: " + rd.getUserId() + ", ");
            System.out.print(new Date(rd.getStart()) + ", ");
            System.out.print(new Date(rd.getEnd()));
        }
        System.out.println();

        //searchResult apartment
        sr = new SearchResult(app);
        sr.filterByCity("Lviv");
        sr.filterByApartmentType("Apartment");
        sr.filterByDates(new Date(115, 8, 16), new Date(115, 8, 17));
        sr.showSearchResults();






        //create loyalty program
        LoyaltyProgram loyaltyProgram = new LoyaltyProgram();
        loyaltyProgram.setLoyaltyProgramName("New Year loyalty program");
        loyaltyProgram.setAvailable(false);

        //Two clients signed for loyalty program notification
        loyaltyProgram.registerObserver(client1);
        loyaltyProgram.registerObserver(client2);
        loyaltyProgram.setAvailable(true);

        //1 of 2 clients decided that he or she doesn't want to receive notifications
        loyaltyProgram.removeObserver(client1);
        loyaltyProgram.setAvailable(true);

    }
}
