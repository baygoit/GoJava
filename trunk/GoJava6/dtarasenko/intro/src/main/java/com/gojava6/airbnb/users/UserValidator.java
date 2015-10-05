package com.gojava6.airbnb.users;

public class UserValidator {

    private String name;
    private String surname;
    private String email;

    public UserValidator(User user) {
        this.name = user.getName();
        this.surname = user.getSurName();
        this.email = user.getEmail();
    }

    public boolean isValidUser() {
        return (isValidNameOrSurname(name) && isValidNameOrSurname(surname) &&
                isValidEmail(email));
    }

    private boolean isValidNameOrSurname(String nameOrSurname) {

        if (nameOrSurname == null) {
            System.out.println("Please correct name or surname input");
            return false;
        }

        char[] textByChar = nameOrSurname.toCharArray();

        for (char c : textByChar) {
            if (!Character.isLetter(c)) {
                System.out.println("Please correct name or surname input");
                return false;
            }
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        boolean isValid = email.matches(EMAIL_REGEX);

        if (!isValid) {
            System.out.println("Please correct email input");
            return false;
        }
        return true;
    }
}
