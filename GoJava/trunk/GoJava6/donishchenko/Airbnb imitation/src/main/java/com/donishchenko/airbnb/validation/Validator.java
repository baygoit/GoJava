package com.donishchenko.airbnb.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private Map<String, String> errors = new HashMap<>();

    private static String nameValidationPatternString =
            "([A-Z][a-z]{1,39})(-([A-Z][a-z]{1,39}))*";
    private static String emailValidationPatternString =
            "([a-z0-9]+([-.]?[a-z0-9])*)@(([a-z](-?[a-z0-9])*){1,40}\\.[a-z]{2,6})";
    private static String cityValidationPatternString =
            "([A-Z][a-z]{1,39})(-?([A-Z][a-z]{1,39}))*";

    private Validator() {}

    public static boolean validateLogin(String login) {
        return validateString(nameValidationPatternString, login);
    }

    public static boolean validatePassword(String password) {
        return validateString(nameValidationPatternString, password);
    }

    public static boolean validateEmail(String email) {
        return validateString(emailValidationPatternString, email);
    }

    /**
     * Not required field.
     * Returns true if empty, otherwise checks by pattern
     */
    public static boolean validateName(String name) {
        return name.equals("") || validateString(nameValidationPatternString, name);
    }

    /**
     * Not required field.
     * Returns true if empty, otherwise checks by pattern
     */
    public static boolean validateSurname(String surname) {
        return surname.equals("") || validateString(nameValidationPatternString, surname);
    }

    public static boolean validateCity(String city) {
        return validateString(cityValidationPatternString, city);
    }

    private static boolean validateString(String patternString, String value) {
        if (value == null) return false;

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(value);

        return matcher.matches();
    }
}
