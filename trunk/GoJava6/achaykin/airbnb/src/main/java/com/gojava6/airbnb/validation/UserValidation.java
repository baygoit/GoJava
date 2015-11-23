package com.gojava6.airbnb.validation;

import com.gojava6.airbnb.Exception.UserValidationException;
import com.gojava6.airbnb.apartment.*;

import java.util.regex.*;

public class UserValidation {

    private static Pattern PATTERN;
    private static Matcher MATCHER;

    public static boolean validationRenter(String name, String surname, String eMail) throws UserValidationException {
        if (validationName(name) && validationSurname(surname) && validationEMail(eMail)) {
            return true;
        }
        return false;
    }

    public static boolean validationName(String firstName) throws UserValidationException {
        if (firstName != null) {
            PATTERN = Pattern.compile("[A-Za-z]*"); //todo check regex
            MATCHER = PATTERN.matcher(firstName);
            if (!firstName.isEmpty()) {
                if (MATCHER.matches()) {
                    return true;
                }
            }
        }
        throw new UserValidationException("Incorrect user first name");
    }

    public static boolean validationSurname(String lastName) throws UserValidationException {
        if (lastName != null) {
            PATTERN = Pattern.compile("[A-Za-z]*");
            MATCHER = PATTERN.matcher(lastName);
            if (!lastName.isEmpty()) {
                if (MATCHER.matches()) {
                    return true;
                }
            }
        }
        throw new UserValidationException("Incorrect user last name");
    }

    public static boolean validationEMail(String eMail) throws UserValidationException {
        if (eMail != null) {
            PATTERN = Pattern.compile("^[A-z0-9-_\\.]+@([\\w]+\\.)+[A-z]{2,4}$");
            MATCHER = PATTERN.matcher(eMail);
            if (!eMail.isEmpty()) {
                if (MATCHER.matches()) {
                    return true;
                }
            }
        }
        throw new UserValidationException("Incorrect user e-Mail");
    }

    public static boolean validationCity(CityType city) throws UserValidationException {

        if (city instanceof CityType) {
            return true;
        }
        throw new UserValidationException("Incorrect city type.");
    }

    public static boolean validationApartmentType(Apartment apartment) throws UserValidationException {

        if (apartment.getApartmentType() instanceof ApartmentType) {
            return true;
        }
        throw new UserValidationException("Incorrect apartment type.");
    }
}
