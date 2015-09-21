package com.gojava6.airbnb;

/**
 * Created by shata on 17.09.2015.
 */
public interface Observer {

    void notifyUsers ();

    void register(User user);
}
