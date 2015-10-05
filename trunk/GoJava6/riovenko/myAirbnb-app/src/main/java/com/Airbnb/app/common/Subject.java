package com.Airbnb.app.common;

import com.Airbnb.app.model.ApartType;
import com.Airbnb.app.model.Client;
import com.Airbnb.app.model.Host;

/**
 * Created by romanroma on 26.09.15.
 */
public interface Subject {
    void registerHost (String name, String surname, String email);
    void registerClient (String name, String surname, String email);
    void removeClient (int id);
    void removeHost (int id);
    int createApartment (int hostId, String city, ApartType apartType, boolean reserved);
    //void notifyAll (String message);
}
