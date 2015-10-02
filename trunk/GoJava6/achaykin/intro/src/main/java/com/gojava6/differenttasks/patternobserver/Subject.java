package com.gojava6.differenttasks.patternobserver;

/**
 * @Autor Andrey Chaykin
 * @Since 26.09.2015
 */
public interface Subject {

    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
