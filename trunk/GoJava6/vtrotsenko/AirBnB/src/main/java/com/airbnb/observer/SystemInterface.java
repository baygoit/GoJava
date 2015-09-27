package com.airbnb.observer;

/**
 * Created by root on 19.09.15.
 */
public interface SystemInterface {

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyAllObservers(String s);

}


