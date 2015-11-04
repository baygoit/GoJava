package com.donishchenko.airbnb.validation;

import com.donishchenko.airbnb.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    private User user;
    private Map<String, String> errors = new HashMap<>();

    //TODO login pattern
    private static final String loginValidationPatternString =
            "[a-zA-Z0-9]{4,40}";

    //TODO password pattern
    private static final String passwordValidationPatternString =
            "(?=.*\\d*)(?=.*[a-z]*)(?=.*[A-Z]*).{6,100}";

    private static String nameValidationPatternString =
            "([A-Z][a-z]{1,39})(-([A-Z][a-z]{1,39}))*";
    private static String emailValidationPatternString =
            "([a-z0-9]+([-.]?[a-z0-9])*)@(([a-z](-?[a-z0-9])*){1,40}\\.[a-z]{2,6})";
    private static String cityValidationPatternString =
            "([A-Z][a-z]{1,39})(-?([A-Z][a-z]{1,39}))*";

    public UserValidator(User user) {
        this.user = user;
    }

    public void validate() {
        validateLogin(user.getLogin());
        validatePassword(user.getPassword());
        validateEmail(user.getEmail());
        validateName(user.getName());
        validateSurname(user.getSurname());
    }

    public boolean validateLogin(String login) {
        boolean valid = validateString(loginValidationPatternString, login);
        if (!valid) {
            errors.put("login", "Invalid login");
        }
        return valid;
    }

    public boolean validatePassword(String password) {
        boolean valid = validateString(passwordValidationPatternString, password);
        if (!valid) {
            errors.put("password", "Invalid password");
        }
        return valid;
    }

    public boolean validateEmail(String email) {
        boolean valid = validateString(emailValidationPatternString, email);
        if (!valid) {
            errors.put("email", "Invalid email");
        }
        return valid;
    }

    /**
     * Not required field.
     * Returns true if empty, otherwise checks by pattern
     */
    public boolean validateName(String name) {
        boolean valid = name.equals("") || validateString(nameValidationPatternString, name);
        if (!valid) {
            errors.put("name", "Invalid name");
        }
        return valid;
    }

    /**
     * Not required field.
     * Returns true if empty, otherwise checks by pattern
     */
    public boolean validateSurname(String surname) {
        boolean valid = surname.equals("") || validateString(nameValidationPatternString, surname);
        if (!valid) {
            errors.put("surname", "Invalid surname");
        }
        return valid;
    }

    public boolean validateCity(String city) {
        boolean valid = validateString(cityValidationPatternString, city);
        if (!valid) {
            errors.put("city", "Invalid city");
        }
        return valid;
    }

    private boolean validateString(String patternString, String value) {
        if (value == null) return false;

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(value);

        return matcher.matches();
    }

    public boolean hasErrors() {
        return errors.size() != 0;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
