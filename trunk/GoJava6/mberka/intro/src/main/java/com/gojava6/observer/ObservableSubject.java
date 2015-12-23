package com.gojava6.observer;

public interface ObservableSubject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyAllObservers();
}
