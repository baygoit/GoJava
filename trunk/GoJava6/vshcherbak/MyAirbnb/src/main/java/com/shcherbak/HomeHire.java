package com.shcherbak;

import com.shcherbak.model.*;
import com.shcherbak.processing.SQLProcessor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HomeHire {
    private Set<String> cities = new HashSet<>();

    public boolean newCity(Adress adress, Registration registration) {
        if (cities.add(adress.getCity())) {
            registration.update("We have new city " + adress.getCity());
        }
        return false;
    }



    public static void main(String[] args) throws ParseException {
        User user =  new User("Test", "Save", "qwer@site.com", UserType.HOST);
       // Adress adress = new Adress("Test", "Street", 42, 42);
       // Apartment apartment = new Apartment(2, RentType.ROOM, adress);
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Date start = dt.parse("2015-01-15");
        Date end = dt.parse("2015-04-01");
        SQLProcessor processor =
                new SQLProcessor("jdbc:mysql://localhost:3306/airbnb", "root", "atmel");
        //com.shcherbak.Booking book = new com.shcherbak.Booking(processor);
        //com.shcherbak.Registration registration = new com.shcherbak.Registration(processor);
        List<Apartment> apartments = new ArrayList<>();

        processor.openDataBase();
        apartments = processor.search("Kiev", RentType.APARTMENT, start, end);
        //processor.getUsers();
        //processor.addReservation(42, 42, start, end);
        //processor.removeReservation(21);
        //processor.addApartment(apartment);
        //processor.removeApartment(31);
        //apartments = processor.getApartments("Kiev", RentType.APARTMENT);
        //book.clean(5);
        //registration.update("some text");
        processor.closeDataBase();

         for (Apartment apartment: apartments) {
             System.out.println(apartment);
         }
    }
}
