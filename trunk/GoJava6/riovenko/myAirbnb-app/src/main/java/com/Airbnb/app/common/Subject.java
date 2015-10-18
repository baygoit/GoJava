package com.Airbnb.app.common;

import com.Airbnb.app.model.ApartType;
import com.Airbnb.app.model.User;

/**
 * Created by romanroma on 26.09.15.
 */

public interface Subject {
    void registerUser (String name, String surname, String email, Boolean isHost);
    void removeUser (int id);
    void notifyAll (String message);
}
