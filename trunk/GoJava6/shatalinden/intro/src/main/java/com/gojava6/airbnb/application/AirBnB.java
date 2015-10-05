package com.gojava6.airbnb.application;

import com.gojava6.airbnb.data.Lists;
import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.common.Subject;
import com.gojava6.airbnb.user.User;
import com.gojava6.airbnb.user.UserType;
import com.gojava6.airbnb.validator.Validator;

/**
 * Created by shata on 17.09.2015.
 */
public class AirBnB implements Subject {

    @Override
    public void notifyClients(String city) {
        if (Lists.cities.add(city)) {
            for (User user : Lists.clientList) {
                user.update("New city: " + city + " for " + user.getName());
            }
        }
    }

    @Override
    public void register(User user) {
        if (Validator.validation(user)) {
            if(user.getUserType() == UserType.CLIENT)
            Lists.clientList.add(user);
            System.out.println("User " + user.getName() + " registered.");
        }
        else {
            Lists.hostList.add(user);
            System.out.println("Host " + user.getName() + " registered.");
        }
    }

    @Override
    public void remove(User user) {
        if (isHost(user)) {
            for (Apartment apartment :  user.apartments) {
                apartment.user=null;
            }
            Lists.hostList.remove(user);
        }
        else Lists.clientList.remove(user);
    }

    private boolean isHost(User user) {
        if (user.userType == UserType.HOST) return true;
        return false;
    }

    public void getCityApartments(String city) {
        for (User user : Lists.hostList) {
            System.out.println(city + " has next apartments:");
            for (Apartment apartment : user.apartments) {
                if (apartment.city == city) {
                    int num = 1;
                    System.out.println("Number " + num + ": " + apartment.getType() + ", " + apartment.user.getName());
                }
            }
        }
    }
}