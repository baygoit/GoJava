package com.gojava6.airbnb;

import com.gojava6.airbnb.apartment.ApartType;
import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.application.AirBnB;
import com.gojava6.airbnb.reservation.Book;
import com.gojava6.airbnb.user.User;
import com.gojava6.airbnb.user.UserType;

import java.io.IOException;
import java.util.Date;

public class Runner {
    public static void main(String[] args) throws IOException {

        AirBnB airbnb = new AirBnB();

        User client = new User("Dan", "Snow", "dan@asd.com", UserType.CLIENT);
        airbnb.register(client);

        User client1 = new User("Sam", "Justin", "sam@asd.com", UserType.CLIENT);
        airbnb.register(client1);

        User host = new User("John", "Malkolm", "john@asd.com", UserType.HOST);
        airbnb.register(host);
        Apartment apartment = new Apartment(ApartType.ROOM, "Kiev");
        airbnb.notifyClients(host.addApartments(apartment));

        User host1 = new User("Tony", "Jackobson", "tony@gmail.com", UserType.HOST);
        airbnb.register(host1);
        Apartment apartment1 = new Apartment(ApartType.PLACE, "Kiev");
        airbnb.notifyClients(host1.addApartments(apartment1));

        User host2 = new User("Stan", "Ferguson", "stan@gmail.com", UserType.HOST);
        airbnb.register(host2);
        Apartment apartment2 = new Apartment(ApartType.APARTMENT, "New-York");
        airbnb.notifyClients(host2.addApartments(apartment2));

        Book book = new Book();
        book.makeReservation(new Date(2016, 2, 10), new Date(2016, 2, 20), apartment);
        book.makeReservation(new Date(2016, 2, 9), new Date(2016, 2, 19), apartment1);
        book.makeReservation(new Date(2016, 1, 27), new Date(2016, 3, 5), apartment2);
        book.makeReservation(new Date(2015, 1, 1), new Date(2016, 7, 2), apartment);
    }
}