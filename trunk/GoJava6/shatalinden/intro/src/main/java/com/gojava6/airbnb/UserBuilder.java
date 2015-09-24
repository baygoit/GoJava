package com.gojava6.airbnb;

/**
 * Created by shata on 20.09.2015.
 */
public class UserBuilder {

    private static boolean isName;
    private static boolean isSurname;
    private static boolean isEmail;
    private static boolean isCity;

    public static Host createHost(String name, String surname, String email, String city, ApartType type) {
        if (!(isName = validateName(name)))System.out.println("Incorrect name: " + name + ". Please enter new name.");
        if (!(isSurname = validateName(surname)))System.out.println("Incorrect surname: " + surname + ". Please enter new surname.");
        if (!(isEmail = validateEmail(email)))System.out.println("Incorrect email: " + email + ". Please enter new email.");
        if (!(isCity = validateCity(city)))System.out.println("Incorrect city: " + city + ". Please enter new city.");
        if (isName && isSurname && isEmail && isCity) {
            return Host.hostConstructor(name, surname, email, city, type);
        }
        return null;
    }
    public static Client createClient(String name, String surname, String email) {
        if (!(isName = validateName(name)))System.out.println("Incorrect name: " + name + ". Please enter new name.");
        if (!(isSurname = validateName(surname)))System.out.println("Incorrect surname: " + surname + ". Please enter new surname.");
        if (!(isEmail = validateEmail(email)))System.out.println("Incorrect email: " + email + ". Please enter new email.");
        if (isName && isSurname && isEmail) {
            return Client.clientConstructor(name, surname, email);
        }
        return null;
    }
    private static boolean validateName(String name) {
        if (name != null) {
            if (!name.isEmpty()) {
                if (name.matches("[a-zA-Z]+")) return true;
            }
        }
        return false;
    }
    private static boolean validateEmail(String email) {
        if (email != null) {
            if (!email.isEmpty()) {
                if (email.contains("@") && email.contains(".")) return true;
            }
        }
        return false;
    }
    private static boolean validateCity (String city) {
        if (city != null) {
            if (!city.isEmpty()) return true;
        }
        return false;
    }
}
