package com.donishchenko.airbnb.common;

public interface Subject {
    void register(Observer o);
    void remove(Observer o);
    void notifyAllObservers(String message);
}
