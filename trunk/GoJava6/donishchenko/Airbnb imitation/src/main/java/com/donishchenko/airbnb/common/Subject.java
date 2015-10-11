package com.donishchenko.airbnb.common;

public interface Subject<T> {
    void registerObserver(T o);
    void removeObserver(T o);
    void notifyAllObservers(String message);
}
