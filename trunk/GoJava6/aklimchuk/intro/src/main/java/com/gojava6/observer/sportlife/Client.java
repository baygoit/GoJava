package com.javarush.test.level13.lesson11.home07;

import java.util.ArrayList;

/**
 * Created by sergiigetman on 9/16/15.
 */
public class Client implements Observer {
    private String name;
    private String surname;
    private String email;
    private boolean clientType;
    private String city;
    private String appartamentType;
    private ArrayList<String> messages = new ArrayList<String>();



    public ArrayList<String> getMasseges() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public String getAppartamentType() {
        return appartamentType;
    }

    public void setAppartamentType(String appartamentType) {
        this.appartamentType = appartamentType;
    }

    public boolean getClientType() {
        return clientType;
    }

    public void setClientType(boolean clientType) {
        this.clientType = clientType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void update(String message) {
        upMasseges(message);
        System.out.println(message);
    }

    public void upMasseges(String messages) {
        this.messages.add(messages);
    }
}
