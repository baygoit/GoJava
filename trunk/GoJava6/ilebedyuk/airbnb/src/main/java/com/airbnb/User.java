package com.airbnb;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.List;

/**
 * Created by Игорь on 20.09.2015.
 */
public abstract class User implements Observer{
    private String Name;
    private String Surname;
    private String Email;

    public User(String name, String surname, String email) throws Exception {
        if (User.validateName(name) == true && User.validateName(surname) == true && User.validateEmail(email) == true) {
            this.Name = name;
            this.Surname = surname;
            this.Email = email;
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

    protected static boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if (!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }

    private static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public void update(String news) {
        System.out.println("Hello! " + Name + ", today next news: " + news);
    }

}