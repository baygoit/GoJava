package com.airbnb.observer;

import com.airbnb.observer.Observer;

/**
 * Created by Игорь on 21.09.2015.
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
