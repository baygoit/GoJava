package com.Airbnb.app;

/**
 * Created by romanroma on 26.09.15.
 */
public abstract class User implements Observer {
    private String name;
    private String surname;
    private String email;

    public User (String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName (){
        return name;
    }

    public  String getSurname(){
        return surname;
    }

    public  String getEmail(){
        return email;
    }

    public void update(String message) {
        System.out.println (message);
    }
}
