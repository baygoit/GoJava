package com.airbnb;

/**
 * Created by Игорь on 21.09.2015.
 */
public class Main {
    public static void main(String[] args) {
        try {
            User client1 = new User("Vasil", "Boyko", "jhg@gmail.com");
            User client2 = new User("Igor", "Lebedyukk", "igor@gmail.com");
            User host1 = new User("Petro", "Limar", "juy@gmail.com", "Kiev");
            User host2 = new User("Dima", "Tarasenko", "dima@gmail.com", "Lviv");

            Application airbnb = new Application();
            airbnb.register(client1);
            //airbnb.register(client2);
            airbnb.register(host1);
            airbnb.register(host2);


          // Apartment room1 = client1.addApartment(Apartment.ApartmentType.Room, "Kiev");
           Apartment place1 = host1.addApartment(Apartment.ApartmentType.Place, "Lviv");
           Apartment room2 = host1.addApartment(Apartment.ApartmentType.Room, "Kiev");

            ReservationDate period1 = new ReservationDate(11,17);
           // System.out.println(place1.getOwnerName());
            System.out.println(place1.isAvaible(period1));

            client1.makeReservation(place1, period1);
            System.out.println(place1.isAvaible(period1));

            Search search = new Search();

            search.searchByCity(search.getAllApartments(), "Lviv");
            search.searchByDate(search.getAllApartments(), period1);


//            Date period2 = new Date(16,20);

            //List<Apartment> searchApartments = new ArrayList<Apartment>();

            //airbnb.searchByOwner(airbnb.searchByCity(airbnb.getApartments(), "Lviv"), host1);
//             airbnb.searchByDate(airbnb.getApartments(), period2);

//            System.out.println(airbnb.isAvaible(room1, period2));

//            NewsSubscribe newsSubscribe = new NewsSubscribe();
//            newsSubscribe.registerObserver(client1);
//            newsSubscribe.registerObserver(client2);
//
//            newsSubscribe.notifyObservers();

//           newsSubscribe.removeObserver(client1);
//           newsSubscribe.notifyObservers();

        } catch (Exception e) {
            System.out.println("Uncorrect data");
        }

    }

}
