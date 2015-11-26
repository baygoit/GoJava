package com.gojava6.differenttasks.JPALesson;

import javax.persistence.*;

/**
 * @Autor Andrey Chaykin
 * @Since 14.11.2015
 */
@Entity
@Table(name="apartment")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String city;
    @ManyToOne
    @JoinColumn(name="userid")
    private User user;
    private String room;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Apartment{");
        sb.append("id=").append(id);
        sb.append(", city='").append(city).append('\'');
        sb.append(", user=").append(user);
        sb.append(", room='").append(room).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
