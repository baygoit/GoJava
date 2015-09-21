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
        if(App.validateName(user.getName()) == true &&
                App.validateEmail(user.getEmail()) == true &&
                App.validateName(user.getSurname()) == true){
            users.add(user);
            System.out.println("Hello! " + user.getName() + ", you've been registered successfully!");
        } else throw new Exception();

        }

    public static boolean validateName(String name) {
        if (name == null || name.isEmpty() || isAlpha(name) == false){
            return false;
        }
        return true;
    }

    public static boolean validateEmail(String email) {
        if (isValidEmailAddress(email) == false || email == null || email.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean validateCity(String city) {
        if (city == null || city.isEmpty() || isAlpha(city) == false){
            return false;
        }
        return true;
    }

    public static boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if (!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}