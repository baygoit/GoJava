package com.donishchenko.airbnb.common;

public interface Subject<T> {
    void register(T o);
    void remove(T o);
    void notifyAllObservers(String message);
}
