package com.Airbnb.app;

/**
 * Created by romanroma on 26.09.15.
 */
public interface Subject {
    void registerHost (Host host);
    void registerClient (Client client);
    void remove (Host host);
    void remove (Client client);
    void notifyAllClients (String message);
}
