package com.donishchenko.airbnb;

import com.donishchenko.airbnb.model.ApartmentType;
import com.donishchenko.airbnb.model.Client;
import com.donishchenko.airbnb.model.Host;
import com.donishchenko.airbnb.model.User;

public class MainApp {
    public static void main(String[] args) {
        User client = new Client("Dmitry-Vlad", "Onishchenko", "sacr8tum@gmail.com");
        if (client.validate()) {
            System.out.println("User validation: SUCCESS");
        } else {
            System.out.println("User validation: ERROR");
        }

        User host = new Host(
                "Dmitry", "Onishchenko", "dima-rock@i.ua", "Kiev", ApartmentType.PLACE);
        if (host.validate()) {
            System.out.println("Host validation: SUCCESS");
        } else {
            System.out.println("Host validation: ERROR");
        }
    }
}
