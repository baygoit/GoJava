package com.gojava6.airbnb.application;

import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.apartment.ReservationData;
import com.gojava6.airbnb.users.Client;
import com.gojava6.airbnb.users.User;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application {

    private static final Logger log = Logger.getLogger(Application.class);

    private List<User> listOfUsers = new ArrayList<User>();
    private List<Apartment> listOfApartments = new ArrayList<Apartment>();
    private List<ReservationData> listOfReservedDates = new ArrayList<ReservationData>();



    public List<Apartment> getListOfApartments() {
        return listOfApartments;
    }

    public List<ReservationData> getListOfReservedDates() {
        return listOfReservedDates;
    }

    public void registerUser(User user) {
        if (isValidUser(user)) {
            listOfUsers.add(user);
            if (user instanceof Client) {
                System.out.println("\nClient " + user.getName() + " is registered now. Client ID: " + user.getUserId() + ".");
            } else {
                System.out.println("\nHost " + user.getName() + " is registered now. Host ID: " + user.getUserId() + ".");
            }
        } else {
            System.out.println("\nPlease correct registration data.");
        }
    }

    public void addApartment(Apartment apartment) {
        listOfApartments.add(apartment);
        System.out.println("\nApartment is added to listOfApartments. Apartment ID: " + apartment.getApartmentId() + ".");
    }

    public void reserveApartment(int apartmentId, Client client, Date startDate, Date endDate) {

        log.info("Start date: " + startDate.getDate() + " " + (startDate.getMonth() + 1)
                + " " + (startDate.getYear() + 1900) + ". End date: " + endDate.getDate()
                + " " + (endDate.getMonth() + 1) + " " + (endDate.getYear() + 1900) + ".");

        long start = startDate.getTime();
        long end = endDate.getTime();

        if (start > end) {
            System.out.println("\nPlease corrent input dates.");
            log.info("Input date error.");
        }
        else {
            if (listOfReservedDates.isEmpty()) {
                listOfReservedDates.add(new ReservationData(apartmentId, client.getUserId(), startDate, endDate));
                System.out.println("\nReservation is completed.");
                log.info("Reservation is completed.");
            }
            else {
                if (isAvailable(apartmentId, start, end)) {
                    listOfReservedDates.add(new ReservationData(apartmentId, client.getUserId(), startDate, endDate));
                    System.out.println("\nReservation is completed.");
                    log.info("Reservation is completed.");

                }
                else {
                    System.out.println("Reservation is not available.");
                    log.info("Reservation is not available.");
                }
            }
        }
    }



    private boolean isAvailable(int apartmentId, long start, long end) {

        for (ReservationData rd : listOfReservedDates) {
            if (rd.getApartmentId() == apartmentId) {
                if ((end < rd.getStart() || start > rd.getEnd())) {
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidUser(User user) {
        boolean isValid = false;

        if (isValidText(user.getName())) {
            if (isValidText(user.getSurName())) {
                if (isValidEmail(user.getEmail())) {
                    isValid = true;

//                    if (user instanceof Host) {
//                        Host host = (Host) user;
//                        if (host.getApartmentType() != null) {
//                            if (isValidText(host.getCity())) {
//                                isValid = true;
//                            }
//                        }
//                    }
//                    else {
//                        isValid = true;
//                    }
                }
            }
        }
        return isValid;
    } //TODO

    private boolean isValidText(String text) {
        char[] textByChar = text.toCharArray();

        for (char c : textByChar) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    } //TODO

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
    } //TODO

}
