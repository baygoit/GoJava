package com.azuiev;

import com.azuiev.Apartment.ApartType;
import com.azuiev.Apartment.Apartment;
import com.azuiev.DB.DBAirBnB;
import com.azuiev.Organization.Organization;
import com.azuiev.User.User;
import com.azuiev.User.UserRoles;
import org.apache.log4j.Logger;

import java.util.List;

public class AirBnB {

    public static final Logger log = Logger.getLogger(AirBnB.class);
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
        User user2 = userCreator.createUser("Bb", "BB", "b@a.aa");

        sportLife.register(user1);
        sportLife.register(user2);

        Apartment book1 = user2.registerBook("Kiev", "Lenina 1", ApartType.APARTAMENT);
        Apartment book2 = user1.registerBook("Moskva", "Pushkina 1", ApartType.PLACE);

        DBAirBnB db = new DBAirBnB();
        //db.addUser(user1);
        //db.addUser(user2);
        List<User> list = db.selectUser();
        for (User user :list) {
            System.out.println(user);
        }

    }
}
