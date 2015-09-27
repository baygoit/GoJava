package airbnb;

import airbnb.model.Client;
import airbnb.model.Host;
import airbnb.model.RentType;
import airbnb.model.User;

/**
 * Created by slavik on 21.09.2015.
 */

public class App {
    public static void main(String[] args) {
        Base base = new Base();
        User user = new Host("Name", "Surname", "email@site.com", "Kiev", RentType.ROOM);
        base.register(user);
        user =  new Host("Nameone", "Surnameone", "emailone@site.com", "Kiev", RentType.PLACE);
        base.register(user);
        user =  new Host("Nameone", "Surnamefive", "emailone@site.com", "Kiev", RentType.APARTMENT);
        base.register(user);
        user =  new Client("Nametwo", "Surnametwo", "emailtwo@site.com");
        base.register(user);
        user =  new Client("Namethree", "Surnamethree", "emailthree@site.com");
        base.register(user);
        base.notifyAll("ready");
        base.remove("Surnametwo");
        base.notifyAll("minus one");
    }
}
