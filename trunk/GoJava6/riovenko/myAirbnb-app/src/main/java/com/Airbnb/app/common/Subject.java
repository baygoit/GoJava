package com.Airbnb.app.common;

/**
 * Created by romanroma on 26.09.15.
 */

public interface Subject {
    void registerUser (String name, String surname, String email, Boolean isHost);
    void removeUser (int id);
    void notifyAll (String message);
}
