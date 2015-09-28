package com.gojava6.airbnb;

/**
 * Created by shata on 20.09.2015.
 */
public class Validator {

    public static boolean validation(String name, String surname, String email, String city) {
        if (validateName(name)) {
            if (validateName(surname)) {
                if (validateEmail(email)) {
                    if (validateCity(city)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean validateName(String name) {
        if (name != null) {
            if (!name.isEmpty()) {
                if (name.matches("[a-zA-Z]+")) return true;
            }
        }
        return false;
    }
    public static boolean validateEmail(String email) {
        if (email != null) {
            if (!email.isEmpty()) {
                if (email.contains("@") && email.contains(".")) return true;
            }
        }
        return false;
    }
    public static boolean validateCity (String city) {
        if (city != null) {
            if (!city.isEmpty()) return true;
        }
        return false;
    }
}
