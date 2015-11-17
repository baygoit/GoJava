package com.vopanasyuk.observer;

/**
 * Created by Hunky on 21.09.2015.
 */
public interface Subject {

    void register(Observer o);
    void remove(Observer o);
    void notifyAllObservers(String message);

}