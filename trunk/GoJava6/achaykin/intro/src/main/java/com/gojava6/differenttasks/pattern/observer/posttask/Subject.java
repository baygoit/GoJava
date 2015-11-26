package com.gojava6.differenttasks.pattern.observer.posttask;

import com.gojava6.differenttasks.pattern.observer.posttask.Observer;

/**
 * @Autor Andrey Chaykin
 * @Since 26.09.2015
 */
public interface Subject {

    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
