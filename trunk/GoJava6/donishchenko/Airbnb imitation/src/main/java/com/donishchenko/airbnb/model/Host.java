package com.donishchenko.airbnb.model;

import com.google.common.base.Joiner;

public class Host extends User {
    public Host() {}

    public Host(String name, String surname, String email) {
        super(name, surname, email);
    }

    @Override
    public String toString() {
        return Joiner.on("").join("Host{", super.toString(), "}");
    }
}
