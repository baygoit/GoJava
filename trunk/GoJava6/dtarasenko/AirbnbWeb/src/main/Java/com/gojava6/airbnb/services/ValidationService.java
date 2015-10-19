package com.gojava6.airbnb.services;

public class ValidationService {

    public boolean isValidName(String name) {
        if (!isText(name)) {
            System.out.println("Please correct name input");
            return false;
        }
        return true;
    }

    public boolean isValidSurname(String surname) {
        if (!isText(surname)) {
            System.out.println("Please correct surname input");
            return false;
        }
        return true;
    }

    public boolean isValidEmail(String email) {
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        boolean isValid = email.matches(EMAIL_REGEX);

        if (!isValid) {
            System.out.println("Please correct email input");
            return false;
        }
        return true;
    }

    private boolean isText(String nameOrSurname) {
        if (nameOrSurname == null) {
            return false;
        }
        char[] textByChar = nameOrSurname.toCharArray();
        for (char c : textByChar) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

}
