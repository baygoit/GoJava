package com.gojava6.observer.project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by slavik on 21.09.2015.
 */
public class Base implements Observable {

    private List<User> users = new ArrayList<User>();
    @Override
    public void add(User user) {
        users.add(user);
    }
    @Override
    public void remove(String surname) {
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User u = it.next();
            if(u.getSurname() == surname) {
                it.remove();
            }
        }
    }
    @Override
    public void notifyAll(String data) {
        for (User user: users) {
            user.update(data);
        }
    }
}
