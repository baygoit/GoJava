package airbnb;

import airbnb.accounting.ReservationDates;
import airbnb.model.User;
import airbnb.model.RentType;
import airbnb.model.Adress;
import airbnb.model.Apartment;
import airbnb.model.UserType;

import airbnb.processing.SQLProcessor;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Adress adress = new Adress("Kiev", "Street", 42, 21);
        Apartment apartment = new Apartment(2, RentType.ROOM, adress);
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Date start = dt.parse("2015-01-15");
        Date end = dt.parse("2015-04-01");
        SQLProcessor processor =
                new SQLProcessor("jdbc:mysql://localhost:3306/airbnb", "root", "atmel");
        Booking book = new Booking(processor);
        Registration registration = new Registration(processor);
        processor.openDataBase();
        //book.clean(5);
        registration.update("some text");

        processor.closeDataBase();

    }
}
