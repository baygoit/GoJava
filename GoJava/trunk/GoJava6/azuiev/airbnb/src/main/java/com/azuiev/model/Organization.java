package com.azuiev.model;

import com.azuiev.AirBnB;
import com.azuiev.interfaces.Subject;
import com.azuiev.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Lera on 21.09.2015.
 */
public class Organization implements Subject {
    private List<User> users = new ArrayList<User>();
    private Set<String> cities = new TreeSet<String>();

    public Organization() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public void register(Observer o) {
        if (o != null) {
            users.add((User) o);
            AirBnB.log.info("Successfully registered "+ o + "in "+ this);
        } else {
            AirBnB.log.info("Can`t be registered "+ null + " in "+ this);
        }
    }

    public boolean isNewCity(String city){
        return true;
    }

    public void remove(Observer o) {

        users.remove(o);
    }

    public void notifyAllObservers(String message) {
        for (User user :users) {
            user.notifyObserver("Hello, Mr/Mrs "+ user.getName() + " "+ message);
        }

    }

    public void cityAdded(String city) {
        notifyAllObservers("now we work also in "+ city);
    }
}
