package com.airbnb.services;

import com.airbnb.model.User;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Created by Игорь on 06.10.2015.
 */
public class Validator {

    public boolean isValidData(User user) {
        return validateUserData(user.getName()) &&
                validateUserData(user.getSurname()) &&
                validateEmail(user.getEmail()) &&
                validateUserData(user.getCity());
    }
    private boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if (!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }

    private boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    private boolean validateUserData(String name) {
        return !(name == null || name.isEmpty() || isAlpha(name) == false);
    }

    private boolean validateEmail(String email) {
        return !(isValidEmailAddress(email) == false || email == null || email.isEmpty());
    }

}
