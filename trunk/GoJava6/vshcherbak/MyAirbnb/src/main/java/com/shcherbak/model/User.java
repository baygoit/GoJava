package com.shcherbak.model;

import java.util.Date;

public class User {
    private long id;
    private Boolean type;
    private String firstname;
    private String lastname;
    private String email;
    private Boolean notify;
    private Date date;
    private String password;
    private String login;

    public User() {}
    public User(Long id, Boolean type, String firstname, String lastname, String email,
                Boolean notify, Date date, String password, String login) {
        this.id = id;
        this.type = type;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.notify = notify;
        this.date = date;
        this.password = password;
        this.login = login;
    }

    public long getUserID() {
        return id;
    }

    public void setUserID(long userID) {
        this.id = userID;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getNotify() {
        return notify;
    }

    public void setNotify(Boolean notify) {
        this.notify = notify;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean validate() {
        return Validation.validateName(firstname) &&
                Validation.validateName(lastname) &&
                Validation.validateEmail(email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!email.equals(user.email)) return false;
        if (!firstname.equals(user.firstname)) return false;
        if (!lastname.equals(user.lastname)) return false;
        if (!password.equals(user.password)) return false;
        if (!type.equals(user.type)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)id;
        result = 31 * result + type.hashCode();
        result = 31 * result + firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", type=" + type +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", notify=" + notify +
                ", date=" + date +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
