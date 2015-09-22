package com.gojava6.airbnb.application;

import com.gojava6.airbnb.users.Host;
import com.gojava6.airbnb.users.User;

import java.util.ArrayList;
import java.util.List;

public class Application{

    private List<User> listOfUsers = new ArrayList<User>();
    private ApartmentType typePlace = ApartmentType.PLACE;
    private ApartmentType typeRoom = ApartmentType.ROOM;
    private ApartmentType typeApartment = ApartmentType.APARTMENT;

    public void registerUser(User user) {
        if (isValidUser(user)) {
            listOfUsers.add(user);
            System.out.println("User " + user.getName() + " is registered now.");
        }
        else {
            System.out.println("Please correct registration data.");
        }
    }

    private boolean isValidUser(User user) {
        boolean isValid = false;

        if (isValidText(user.getName())) {
            if (isValidText(user.getSurName())) {
                if (isValidEmail(user.getEmail())) {
                    if (user instanceof Host) {
                        Host host = (Host) user;
                        if (isValidText(host.getApartmentType().toString())) {
                            if (isValidText(host.getCity())) {
                                isValid = true;
                            }
                        }
                    }
                    else {
                        isValid = true;
                    }
                }
            }
        }
        return isValid;
    }

    private boolean isValidText(String text) {

        boolean isValid = true;

        String s = new String();
        for (char c = 'A'; c <= 'z'; c++) {
            s += c;
        }

        char[] alphabet = s.toCharArray();
        char[] textByChar = text.toCharArray();


        for (int i = 0; i < textByChar.length; i++) {
            boolean check = false;
            for (int k = 0; k < alphabet.length; k++) {
                if (textByChar[i] == alphabet[k]) {
                    check = true;
                }
            }
            if (check == false) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    private boolean isValidEmail(String text) {

        boolean isValid = true;

        String s = new String();
        for (char c = 'A'; c <= 'z'; c++) {
            s += c;
        }

        char[] alphabet = s.toCharArray();
        char[] emailByChar = text.toCharArray();


        for (int i = 0; i < emailByChar.length; i++) {
            boolean check = false;
            for (int k = 0; k < alphabet.length; k++) {
                if (emailByChar[i] == alphabet[k]) {
                    check = true;
                }
            }
            if (emailByChar[i] == '@') {
                check = true;
            }
            if (emailByChar[i] == '.') {
                check = true;
            }
            if (check == false) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public ApartmentType getTypePlace() {
        return typePlace;
    }

    public ApartmentType getTypeRoom() {
        return typeRoom;
    }

    public ApartmentType getTypeApartment() {
        return typeApartment;
    }
}
