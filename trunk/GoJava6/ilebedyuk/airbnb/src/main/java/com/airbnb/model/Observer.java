package com.airbnb.model;

import javax.persistence.*;

/**
 * Created by Игорь on 16.11.2015.
 */
@Entity
@Table(name="observer")
public class Observer {
    @Id
    int idobserver;

    @OneToOne
    @JoinColumn(name = "idobserver")
    private User user;

    @Override
    public String toString() {
        return "Observer{" +
                "idobserver=" + idobserver +
                ", user=" + user +
                '}';
    }

    public int getIdobserver() {
        return idobserver;
    }

    public void setIdobserver(int idobserver) {
        this.idobserver = idobserver;
    }

    public Observer() {}

    public Observer(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
