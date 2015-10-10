package airbnb.common;

/**
 * Created by slavik on 09.10.2015.
 */
import airbnb.model.Adress;
import airbnb.model.RentType;
import airbnb.model.User;

public interface Processor {
    //void openDataBase();
    //void closeDataBase();
    void registerUser(User user);
    void removeUser(String surname);
    void addApartment(User user, RentType rent, Adress adress);
    void removeApartment(int id);
}
