package com.azuiev.Organization;

import com.azuiev.App;
import com.azuiev.Organization.Subject;
import com.azuiev.Users.Observer;
import com.azuiev.Users.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lera on 21.09.2015.
 */
public class Organization implements Subject {
    List<User> users = new ArrayList<User>();

    public Organization() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public void register(Observer o) {
        if (o != null) {
            users.add((User) o);
            App.log.info("Successfully registered "+ o + "in "+ this);
        } else {
            App.log.info("Can`t be registered "+ null + "in "+ this);
        }
    }



    public void remove(Observer o) {

        users.remove(o);
    }

    public void notifyAllObservers(String message) {
        for (User user :users) {
            //TODO
        }

    }
}
