package com.gojava6.airbnb;

import java.io.IOException;
import java.util.GregorianCalendar;

/**
 * Created by shata on 18.09.2015.
 */

public class Application {
    public static void main(String[] args) throws IOException {

        AirBnB airbnb = new AirBnB();

        Client client1 = new Client("John", "Malkolm", "asd@asd.com", "Kiev");
        airbnb.register(client1);
        Client client2 = new Client("Sam", "Morrison", "sam@gmail.com", "Kiev");
        airbnb.register(client2);
        Host host1 = new Host("Dan", "Jamson", "qweqwe@gmail.com", "New-York");
        airbnb.register(host1);
        Apartment host1Apartament = new Apartment(ApartType.ROOM);
        host1.addApartments(host1Apartament);
        Host host2 = new Host("Jack", "Gray", "jack@gmail.com", "New-York");
        airbnb.register(host2);
        Apartment host2Apartament = new Apartment(ApartType.APARTMENT);
        host2.addApartments(host2Apartament);
        Client client3 = new Client("Tony", "Jackobson", "tony@gmail.com", "Kiev");
        airbnb.register(client3);
        Host host3 = new Host("Nick", "Samuel", "nick@gmail.com", "Dallas");
        airbnb.register(host3);
        Apartment host3Apartament = new Apartment(ApartType.PLACE);
        host3.addApartments(host3Apartament);

        airbnb.getCityApartments("New-York");

        Book book = new Book();
        book.makeReservation(new GregorianCalendar(2016, 2, 10), new GregorianCalendar(2016, 2, 20), host1Apartament);
        book.makeReservation(new GregorianCalendar(2016, 3, 25), new GregorianCalendar(2016, 3, 28), host2Apartament);
        book.makeReservation(new GregorianCalendar(2016, 2, 15), new GregorianCalendar(2016, 4, 25), host1Apartament);

    }
}