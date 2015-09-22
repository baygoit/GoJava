package com.airbnb;

/**
 * Created by Игорь on 21.09.2015.
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
