package com.azuiev;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lera on 21.09.2015.
 */
public class Organisation implements Subject {
    List<User> users = new ArrayList<User>();
    public void register(Observer o) {
        users.add((User) o);
    }

    public void remove(Observer o) {
        users.remove(o);
    }

    public void notifyAllObservers(String message) {
        for (User user :users) {

        }

    }
}
