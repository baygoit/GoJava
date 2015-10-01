package com.azuiev;

import com.azuiev.Books.ApartType;
import com.azuiev.Books.Apartment;
import com.azuiev.Organization.Organization;
import com.azuiev.Users.User;
import com.azuiev.Users.UserRoles;
import org.apache.log4j.Logger;

public class App {

    public static final Logger log = Logger.getLogger(App.class);
    public static Organization sportLife = new Organization();

    public static void main(String[] args) {

        log.trace("AIRBNB project");

        if (sportLife!=null){
            log.info("Organization successfully created");
        } else {
            log.error("Organization creating failed");
        }

        User.Builder userCreator = User.createBuilder();

        User user1 = userCreator.createUser("Aa", "TT", "a@a.aa", UserRoles.CLIENT, UserRoles.HOST);
        User host1 = userCreator.createUser("AA", "BB", "a@a.aa");

        sportLife.register(user1);
        sportLife.register(host1);

        Apartment book1 = host1.registerBook("Kiev", "Lenina 1", ApartType.APARTAMENT);
        Apartment book2 = user1.registerBook("Moskva", "Pushkina 1", ApartType.PLACE);

    }
}
