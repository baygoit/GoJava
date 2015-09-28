package com.observer.sportlife;

/**
 * Created by sergiigetman on 9/16/15.
 */
public interface Subject {
    void register(Observer o);
    void remove(Observer o);
    void notifyAllObservers();
}
