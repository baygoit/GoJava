package com.gojava6.airbnb;

/**
 * Created by shata on 17.09.2015.
 */
public interface Subject {

    void notifyUsers (String message);

    void register(User user);

    void remove(User user);
}
