package com.airbnb;

import com.airbnb.apartment.*;
import com.airbnb.observer.*;
import com.airbnb.system.*;
import com.airbnb.user.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

/**
 * Created by root on 19.09.15.
 */
public class Application {

    public static void main(String args[]) {

        AirBnBSystem airBnB =  new AirBnBSystem();
        User user1 = new User("Sasha", "Ivanova", "sasha.i@gmail.com");
        airBnB.registerUser(user1);

        user1.becomeHost(airBnB, "Kyiv", new Integer(1), ApartmentType.PLACE,
                LocalDate.of(2015, 9, 10), LocalDate.of(2015, 9, 20));

        User user2 = new User("Sergii", "Smirnoff", "smirnoff@gmail.com");
        airBnB.registerUser(user2);

        user2.becomeHost(airBnB, "Kyiv", new Integer(1), ApartmentType.APARTMENT,
                LocalDate.of(2015, 10, 3), LocalDate.of(2015, 11, 3));

        user1.registerApartment(new Integer(2), ApartmentType.ROOM, LocalDate.of(2015, 9, 13), LocalDate.of(2015, 9, 14));

        System.out.println("Available apartments: ");
        for (Observer observer : airBnB.getListOfObservers()) {
            User user = (User) observer;
            System.out.println(" ---- City: " + user.getCity());
            for (Map.Entry<Integer, Apartment> entry : user.getListOfApartments().entrySet()) {
                Apartment apartment = entry.getValue();
                System.out.println("ApartmentType: " + apartment.getApartmentType());
                System.out.println("Available date: " + apartment.getFirstDayAvailable() +
                        " - " + apartment.getLastDayAvailable());
            }
        }

        airBnB.makeReservation(user2, user1, 1, LocalDate.of(2015, 9, 10), LocalDate.of(2015, 9, 20));
    }
}