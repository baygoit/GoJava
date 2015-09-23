package com.airbnb;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ����� on 20.09.2015.
 */
public class App {
    private List<User> users = new ArrayList<User>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void register(User user) throws Exception {
        if(user.validateName(user.getName()) == true &&
                user.validateEmail(user.getEmail()) == true &&
                user.validateName(user.getSurname()) == true){
            users.add(user);
            System.out.println("Hello! " + user.getName() + ", you've been registered successfully!");
        } else throw new Exception();

        }

}