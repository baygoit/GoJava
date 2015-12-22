package com.gojava6.observer;

/*Singleton*/

public class Validation {

    private static Validation validation = new Validation();

    private Validation(){
    }

    public static Validation getValidation(){
        return validation;
    }

    public boolean validUserName(String userName) {
        try {
            if (!userName.isEmpty() && userName.matches("[a-zA-Z]+")) {
                return true;
            } else {
                throw new Exception("NotValidUserNameException");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validUserSurname(String userSurname) {
        try {
            if (!userSurname.isEmpty() && userSurname.matches("[a-zA-Z]+")) {
                return true;
            } else {
                throw new Exception("NotValidUserNameException");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validEmail(String email) {
        try {
            if (!email.isEmpty() && email.contains("@") && email.contains(".")) {
                return true;
            } else {
                throw new Exception("NotValidUserNameException");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validCityName(String city) {
        try {
            if (!city.isEmpty() && city.matches("[a-zA-Z]+")) {
                return true;
            } else {
                throw new Exception("NotValidCityNameException");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
