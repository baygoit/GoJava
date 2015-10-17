package com.Airbnb.app.model;

import com.Airbnb.app.common.Observer;
import com.Airbnb.app.validation.Validator;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by romanroma on 26.09.15.
 */
public class User implements Observer {
    private static int user_id = 0;
    private int id;
    private String name;
    private String surname;
    private String email;
    private boolean host;

    public User (String name, String surname, String email){
        this.id = ++user_id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.host = false;
    }

    public int getId (){
        return id;
    }

    public void setId (int id){
        this.id = id;
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

    public boolean isHost(){
        return host;

    }

    public void setHost(boolean host){
        this.host = host;
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
