package com.donishchenko.airbnb.model;

import com.google.common.base.Joiner;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "isHost")
    private boolean isHost;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    public User() {}

    public User(String login, String password, String email) {
        this(login, password, email, false, "", "");
    }

    public User(String login, String password, String email, boolean isHost) {
        this(login, password, email, isHost, "", "");
    }

    public User(String login, String password, String email, boolean isHost, String name, String surname) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.isHost = isHost;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isHost() {
        return isHost;
    }

    public void setHost(boolean host) {
        this.isHost = host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;

        if (!(obj instanceof User)) return false;

        User other = (User) obj;

        return id == other.id &&
                login.equals(other.login) &&
                password.equals(other.password) &&
                email.equals(other.email) &&
                isHost == other.isHost &&
                name.equals(other.name) &&
                surname.equals(other.surname);
    }

    @Override
    public String toString() {
        return Joiner.on("").join(
                "User{id='", id, "', login='", login, "', pass=", password, "', email='", email,
                "', isHost='", isHost, "', name='", name, "', surname='", surname, "'}");
    }
}
