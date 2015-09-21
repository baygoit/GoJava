package com.gojava6.observer.project;

/**
 * Created by slavik on 21.09.2015.
 */
class User implements Observer {
    private String name, surname, email;

    User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    @Override
    public void update(String message) {
        System.out.println("send message: " + message + " to " + email);
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getEmail() {
        return email;
    }
}
