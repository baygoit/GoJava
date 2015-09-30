package com.azuiev;

import com.azuiev.Books.ApartType;
import com.azuiev.Books.Book;
import com.azuiev.Organization.Organization;
import com.azuiev.Users.Client;
import com.azuiev.Users.Host;
import com.azuiev.Users.User;
import com.azuiev.Users.UserCreator;
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

        UserCreator userCreator = new UserCreator();

        User user1 = userCreator.createUser(new Client("Aa", "TT", "a@a.aa"));
        Host host1 = new Host("AA", "BB", "a@a.aa");
        sportLife.register(user1);
        sportLife.register(host1);

        Book book1 = host1.createBook("Kiev", "Lenina 1", ApartType.APARTAMENT);



    }
}
