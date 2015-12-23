package com.gojava6.Spring;

/**
 * Created by root on 23.11.15.
 */
public interface Subject {

    void add(Observer...args);
    void remove();
    void notifyObservers();
}
