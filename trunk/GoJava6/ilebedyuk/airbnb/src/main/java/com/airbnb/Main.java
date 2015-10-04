package com.airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Игорь on 21.09.2015.
 */
public class Main {
    public static void main(String[] args) {
        try {
            User client1 = new Client("Vasil", "Boyko", "jhg@gmail.com");
            User client2 = new Client("Igor", "Lebedyukk", "igor@gmail.com");
            User host1 = new Host("Petro", "Limar", "juy@gmail.com", "Kiev");
            User host2 = new Host("Dima", "Tarasenko", "dima@gmail.com", "Lviv");

            App airbnb = new App();
            airbnb.register(client1);
            //airbnb.register(client2);
            airbnb.register(host1);
            airbnb.register(host2);

            //airbnb.getClients();
            //airbnb.getHosts();


            Apartment room1 = airbnb.createApartment(Apartment.ApartmentType.Room, "Kiev", host1);
            Apartment place1 = airbnb.createApartment(Apartment.ApartmentType.Place, "Lviv", host1);
            Apartment place2 = airbnb.createApartment(Apartment.ApartmentType.Place, "Lviv", host2);

            //airbnb.getApartments();
            Date period1 = new Date(11,17);
            Date period2 = new Date(16,20);

            //System.out.println(airbnb.IsAvaible(room1, period1));

            airbnb.makeReservation(client1, room1, period1);

            //System.out.println(airbnb.IsAvaible(room1, period1));

            //List<Apartment> searchApartments = new ArrayList<Apartment>();

            //airbnb.searchByOwner(airbnb.searchByCity(airbnb.getApartments(), "Lviv"), host1);
             airbnb.searchByDate(airbnb.getApartments(), period2);

//            System.out.println(airbnb.IsAvaible(room1, period2));

            NewsSubscribe newsSubscribe = new NewsSubscribe();
            newsSubscribe.registerObserver(client1);
            newsSubscribe.registerObserver(client2);

            newsSubscribe.notifyObservers();

//           newsSubscribe.removeObserver(client1);
//           newsSubscribe.notifyObservers();

        } catch (Exception e) {
            System.out.println("Uncorrect data");
        }

    }

}
