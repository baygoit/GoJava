package com.airbnb;

import com.airbnb.model.Apartment;
import com.airbnb.model.ReservationDate;
import com.airbnb.model.User;
import com.airbnb.services.ApartamentService;
import com.airbnb.services.NewsSubscribeService;
import com.airbnb.services.ReservationDatesService;
import com.airbnb.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Игорь on 21.09.2015.
 */
public class Airbnb {
    public static void main(String[] args) {
        try {
            User client1 = new User("Vasil", "Boyko", "jhg@gmail.com", "Kiev", "Client");
            User client2 = new User("Igor", "Lebedyukk", "igor@gmail.com", "Lviv", "Client");
            User host1 = new User("Petro", "Limar", "juy@gmail.com", "Kiev", "Host");
            User host2 = new User("Dima", "Tarasenko", "dima@gmail.com", "Lviv", "Host");
            Search search = new Search();

            Apartment apartment1 = new Apartment("Room", "Kiev", 13);
            Apartment apartment2 = new Apartment("Room", "Lviv", 13);

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            ReservationDate dates1 = new ReservationDate(sdf.parse("10-09-2015").getTime(), sdf.parse("15-09-2015").getTime(), 4);
            ReservationDate dates2 = new ReservationDate(sdf.parse("10-10-2015").getTime(), sdf.parse("17-10-2015").getTime(), 4);

//            UserService userService = new UserService();

//            JDBCUserDataAcces jdbcUserDataAcces = new JDBCUserDataAcces();
//            UserService userService = new UserService(jdbcUserDataAcces);

            ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

            UserService userService = (UserService) context.getBean("userService");
            ApartamentService apartamentService = (ApartamentService) context.getBean("apartamentService");
            ReservationDatesService reservationDatesService = (ReservationDatesService) context.getBean("reservationDatesService");
            NewsSubscribeService newsSubscribeService = (NewsSubscribeService) context.getBean("newsSubscribeService");

            //userService.registerUser(host2);
            //userService.printUsers();
//            apartamentService.registerApartament(apartment1);
//            apartamentService.registerApartament(apartment2);
            //apartamentService.printApartaments();
            //apartamentService.printApartamentsByIdUser(13);

            /*reservationDatesService.addReservationDate(dates1);
            reservationDatesService.addReservationDate(dates2);*/
            //reservationDatesService.printReservationDates();
            //reservationDatesService.printReservationDatesByIdApartament(4);
//            apartamentService.printApartaments();

            //System.out.println(reservationDatesService.isAvailableApartment(4, sdf.parse("10-10-2015").getTime(), sdf.parse("17-10-2015").getTime()));
           List<Apartment> apartments = apartamentService.getAllApartments();

            List<Apartment> searchedApartments = search.searchByCity(apartments, "Lviv");
            List<Apartment> searchedApartmentsA = search.searchByOwner(apartments, 13);
            List<Apartment> searchedApartmentsB = search.searchByDate(apartments, reservationDatesService, sdf.parse("10-10-2015").getTime(), sdf.parse("17-10-2015").getTime());

            search.printSearchedApartments(searchedApartmentsB);
            reservationDatesService.printReservationDates();


            //reservationDatesService.getReservationDateById(1);

            //apartamentService.deleteApartament(1);

           // userService.printUsers();
            //userService.registerUser(client1);
            //userService.update(client2);
            //userService.deleteUser(10);
            //userService.registerUser(client2);
            //userService.registerUser(host1);
            //userService.registerUser(host2);
            //userDataAcces.clearTable();
            //userService.printAllUsers();

//
//
//          // Apartment room1 = client1.addApartment(Apartment.ApartmentType.Room, "Kiev");
//           Apartment place1 = host1.addApartment(Apartment.ApartmentType.Place, "Lviv");
//           Apartment room2 = host1.addApartment(Apartment.ApartmentType.Room, "Kiev");
//
//            ReservationDate period1 = new ReservationDate(11,17);
//           // System.out.println(place1.getOwnerName());
//            System.out.println(place1.isAvaible(period1));
//
//            client1.makeReservation(place1, period1);
//            System.out.println(place1.isAvaible(period1));
//
//            Search search = new Search();
//
//            search.searchByCity(search.getAllApartments(), "Lviv");
//            search.searchByDate(search.getAllApartments(), period1);
//
//
////            Date period2 = new Date(16,20);
//
//            //List<Apartment> searchApartments = new ArrayList<Apartment>();
//
//            //airbnb.searchByOwner(airbnb.searchByCity(airbnb.getApartments(), "Lviv"), host1);
////             airbnb.searchByDate(airbnb.getApartments(), period2);
//
////            System.out.println(airbnb.isAvaible(room1, period2));
//
////            NewsSubscribeService newsSubscribe = new NewsSubscribeService();
////            newsSubscribe.registerObserver(client1);
////            newsSubscribe.registerObserver(client2);
////
////            newsSubscribe.notifyObservers();
//
////           newsSubscribe.removeObserver(client1);
////           newsSubscribe.notifyObservers();

//        } catch (SQLException e) {
//            System.out.println("SQL error");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
