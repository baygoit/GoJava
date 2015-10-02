package airbnb;

import airbnb.model.Client;
import airbnb.model.Host;
import airbnb.model.RentType;
import airbnb.model.User;

import java.text.ParseException;

public class App {
    public static void main(String[] args) throws ParseException {
        HomeHire hire = new HomeHire();
        User user =  new Client("Jon", "Scott", "scott@site.com");
        hire.register(user);
        user =  new Client("Dylan", "Robinson", "robinson@site.com");
        hire.register(user);
        user = new Host("Brenda", "Taylor", "taylor@site.com", "Kiev", RentType.ROOM);
        hire.register(user);
        user =  new Host("Donna", "Small", "small@site.com", "Odessa", RentType.PLACE);
        hire.register(user);
        user =  new Host("Angle", "Baker", "baker@site.com", "Kiev", RentType.APARTMENT);
        hire.register(user);
        /*
        hire.notifyAll("ready");
        hire.remove("Small");
        hire.notifyAll("minus one");
        */
        int id = hire.search("Kiev", RentType.ROOM, "2015-10-05", "2015-10-10");
        System.out.println(id);
        id = hire.search("Kiev", RentType.APARTMENT, "2015-10-05", "2015-10-10");
        System.out.println(id);
        id = hire.search("Odessa", RentType.PLACE, "2015-10-05", "2015-10-10");
        System.out.println(id);
        id = hire.search("Kiev", RentType.PLACE, "2015-10-05", "2015-10-10");
        System.out.println(id);

        hire.getAllApartment();
    }
}
