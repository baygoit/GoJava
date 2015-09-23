package com.azuiev;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lera on 21.09.2015.
 */
public class Validator {
    private static Validator validator;
    private Validator(){

    }
    public static Validator getInstance(){
        if (validator!=null) {
            return validator;
        }
        else return new Validator();
    }

    public boolean validateUser(User user) {
        Boolean result;
        result = validate(user);
        if (user instanceof Client) {
            return result&&validate((Client) user);
        }
        if (user instanceof Host) {
            return result&&validate((Host) user);
        }
        else return false;
    }

    private boolean validate(User user) {
        return validateName(user.name)&&validateSurname(user.surName)&&validateEmail(user.email);
    }

    private boolean validate(Host host) {
        return validateCity(host.city)&&validateApartament(host.apartmentType);
    }

    private boolean validateApartament(ApartType apartmentType) {
        return (apartmentType instanceof ApartType);
    }

    private boolean validateCity(String city) {
        return validateString(city,"[a-zA-Z]{1}[a-zA-Z]");
    }


    private boolean validate(Client client) {
        return true;
    }


    private boolean validateEmail(String email) {
        return false;
    }

    private boolean validateSurname(String surName) {
        return false;
    }

    private boolean validateName(String name) {
        return false;
    }


    private boolean validateString(String string, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(string);
        return m.matches();

    }
}
