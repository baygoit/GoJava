package airbnb.common;

/**
 * Created by slavik on 09.10.2015.
 */
import airbnb.model.Adress;
import airbnb.model.Apartment;
import airbnb.model.RentType;
import airbnb.model.User;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface Processor {
    //void openDataBase();
    //void closeDataBase();
    void addUser(User user);
    void removeUser(int user_id);
    void addApartment(Apartment apartment);
    void removeApartment(int id);
    void addReservation(int apartmentID, int clientID, Date start, Date end);
    void removeReservation(int reservation_id);
    List<Apartment> search( String city, RentType rent, Date start, Date end ) throws ParseException;
}
