package com.gojava6.airbnb;

/**
 * Created by Sergio on 18-Sep-15.
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
