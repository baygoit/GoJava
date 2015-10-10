package airbnb.common;

/**
 * Created by slavik on 09.10.2015.
 */
import airbnb.model.Adress;
import airbnb.model.Apartment;
import airbnb.model.RentType;
import airbnb.model.User;

public interface Processor {
    //void openDataBase();
    //void closeDataBase();
    void addUser(User user);
    void removeUser(int user_id);
    void addApartment(Apartment apartment);
    void removeApartment(int id);
}
