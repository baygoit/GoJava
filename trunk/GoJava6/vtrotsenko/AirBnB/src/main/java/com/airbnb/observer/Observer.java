package com.airbnb.observer;

/**
 * Created by root on 19.09.15.
 */
public interface Observer {

    void update(String s);
    String getName();
    String getSurname();
    String getEmail();
}