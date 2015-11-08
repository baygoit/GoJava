package com.gojava6.airbnb.validator;

import com.gojava6.airbnb.user.User;

/**
 * Created by shata on 20.09.2015.
 */
public class Validator {

    public static boolean validation(User user) {
        if (validateName(user.getName())) {
            if (validateName(user.getSurname())) {
                if (validateEmail(user.getEmail())) {
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean validateName(String name) {
        if (name != null) {
            if (!name.isEmpty()) {
                if (name.matches("[a-zA-Z]+")) return true;
            }
        }
        System.out.println("Wrong name or surname: " + name);
        return false;
    }
    private static boolean validateEmail(String email) {
        if (email != null) {
            if (!email.isEmpty()) {
                if (email.contains("@") && email.contains(".")) return true;
            }
        }
        System.out.println("Wrong email: " + email);
        return false;
    }
    public static boolean validateCity(String city) {
        if (city != null) {
            if (!city.isEmpty()) return true;
        }
        return false;
    }
}
