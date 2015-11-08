package com.gojava6.airbnb.model;

public class Subscriber {

    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "userId=" + userId +
                '}';
    }

}
