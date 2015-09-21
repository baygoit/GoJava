package com.gojava6.airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shata on 17.09.2015.
 */
public class AirBnB implements Observer{

    public AirBnB() {
    }

    private List<User> userList = new ArrayList<User>();
    private List<String> cities = new ArrayList<String>();

    public void notifyUsers() {
        for(User user : userList) {
            System.out.println(user.getName() + " notified.");
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

    private void addCity(String city) {
        if(!cities.contains(city)) notifyUsers();
        cities.add(city);
    }

}
