package com.airbnb.observer;

/**
 * Created by Игорь on 21.09.2015.
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(int id);
    void notifyObservers();
}
