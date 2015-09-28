package com.Airbnb.app;

/**
 * Created by romanroma on 26.09.15.
 */
public abstract class User implements Observer {
    private int id;
    private String name;
    private String surname;
    private String email;

    public User (String name, String surname, String email){
        //this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName (){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public  String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public  String getEmail(){
        return email;
    }

    public  void setEmail(String email){
        this.email = email;
    }

    public void update(String message) {
        System.out.println("send message: " + message + " to " + email);
    }

    public boolean validation() {
        return Validator.validateUserName(name)&&
                Validator.validateUserSurname(surname)&&
                Validator.validateUserEmail(email);
    }
}
