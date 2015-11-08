package com.gojava6.airbnb.common;

import com.gojava6.airbnb.user.User;

/**
 * Created by shata on 17.09.2015.
 */
public interface Subject {

    void notifyClients(String message);

    void register(User user);

    void remove(User user);
}
