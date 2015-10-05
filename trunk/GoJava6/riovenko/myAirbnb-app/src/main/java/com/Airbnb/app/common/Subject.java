package com.Airbnb.app.common;

import com.Airbnb.app.model.Client;
import com.Airbnb.app.model.Host;

/**
 * Created by romanroma on 26.09.15.
 */
public interface Subject {
    void registerHost (Host host);
    void registerClient (Client client);
    void removeClient (int id);
    void removeHost (int id);
    void notifyAll (String message);
}
