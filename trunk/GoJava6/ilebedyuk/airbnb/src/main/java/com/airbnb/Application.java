package com.airbnb;

import java.util.*;
import org.apache.log4j.Logger;

/**
 * Created by Игорь on 05.10.2015.
 */
public class Application {
    private static List<User> users = new ArrayList<User>();
    private static final Logger log = Logger.getLogger(Apartment.class);

    public static List<User> getUser() {
        return users;
    }

    public void register(User user){
        users.add(user);
        System.out.println(user.getName() + " registered successfully like a " + user.getUserType());
        log.info("User is registered");
    }
}
