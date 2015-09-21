package com.donishchenko.airbnb.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static String nameValidationPatternString =
            "([A-Z][a-z]{1,39})(-([A-Z][a-z]{1,39}))*";
    private static String emailValidationPatternString =
            "([a-z]([-.]?[a-z0-9])*){5,40}@(([a-z](-?[a-z0-9])*){1,40}\\.[a-z]{2,6})";
    private static String cityValidationPatternString =
            "([A-Z][a-z]{1,39})(-?([A-Z][a-z]{1,39}))*";

    private Validator() {}

    public static boolean validateName(String name) {
        return validateString(nameValidationPatternString, name);
    }

    public static boolean validateSurname(String surname) {
        return validateString(nameValidationPatternString, surname);
    }

    public static boolean validateEmail(String email) {
        return validateString(emailValidationPatternString, email);
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
