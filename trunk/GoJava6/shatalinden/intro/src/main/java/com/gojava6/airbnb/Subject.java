package com.gojava6.airbnb;

/**
 * Created by shata on 17.09.2015.
 */
public interface Subject {

    void notifyClients(String message);

    void register(Host host);

    void register(Client client);

    void remove(User user);
}
