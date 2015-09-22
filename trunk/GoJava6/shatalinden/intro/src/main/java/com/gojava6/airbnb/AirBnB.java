package com.gojava6.airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shata on 17.09.2015.
 */
public class AirBnB implements Subject{

    public AirBnB() {
    }

    private List<User> userList = new ArrayList<User>();
    private List<String> cities = new ArrayList<String>();

    public void notifyUsers(String message) {
        for(User user : userList) {
//            System.out.println(user.getName() + " notified.");
            user.update("New city: " + message + ", for " + user.getName().toString());
        }
    }

    public void register(User user) {
        if(user==null) {
            System.out.println("User not registered.");
        }
        else userList.add(user);
        if(user != null && user.getClass().toString().contains("Host")) {
            addCity(user.getCity());
        }
    }

    public void remove(User user) {
        userList.remove(user);
    }

    private void addCity(String city) {
        if(!cities.contains(city)) notifyUsers(city);
        cities.add(city);
    }

}
