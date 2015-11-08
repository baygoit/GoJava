package com.javarush.test.level13.lesson11.home07;

import java.io.IOException;

/**
 * Created by sergiigetman on 9/16/15.
 */
public interface Subject {
    void register(Client o) throws IOException;
    void remove(Client o);
    void notifyAllObservers();
}
