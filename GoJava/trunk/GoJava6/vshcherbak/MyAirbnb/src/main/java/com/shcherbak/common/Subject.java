package com.shcherbak.common;

import com.shcherbak.model.User;

public interface Subject {
    void register(User user);
    void remove(String surname);
}
