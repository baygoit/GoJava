package com.gojava6.airbnb.users;

import com.gojava6.airbnb.observer.Observer;

public class Client extends User implements Observer {

    @Override
    public void update(String loyaltyProgramName) {
        System.out.println(getName() + ", " + loyaltyProgramName + " is available for you!");
    }
}
