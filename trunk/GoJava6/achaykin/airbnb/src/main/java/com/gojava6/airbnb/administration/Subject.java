package com.gojava6.airbnb.administration;

/**
 * @Autor Andrey Chaykin
 * @Since 27.10.2015
 */
public interface Subject {
    void notifyAllObservers();

    void notifyAllRenters();

    void notifyAllHosts();
}
