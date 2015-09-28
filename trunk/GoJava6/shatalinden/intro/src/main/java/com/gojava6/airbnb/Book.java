package com.gojava6.airbnb;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by sergiigetman on 9/23/15.
 */
public class Book {
    String city;
    List<ReservationDates> reservationDates = new ArrayList<>();

    public boolean isDatesAvailable(GregorianCalendar start, GregorianCalendar end, Apartment apartment) {
        for (ReservationDates reserved : reservationDates) {
            if (reserved.apartment == apartment) {
                if ((start.after(reserved.start) && start.before(reserved.end))) {
                    System.out.println(apartment.getType() + ", " + apartment.host.getName()
                            + " is booked, for these dates. Try another apartment or dates.");
                    return false;
                }
                if ((end.after(reserved.start) && end.before(reserved.end))) {
                    System.out.println(apartment.getType() + ", " + apartment.host.getName()
                            + " is booked, for these dates. Try another apartment or dates.");
                    return false;
                }
                if ((reserved.start.after(start) && reserved.start.before(end))) {
                    System.out.println(apartment.getType() + ", " + apartment.host.getName()
                            + " is booked, for these dates. Try another apartment or dates.");
                    return false;
                }
                if ((reserved.end.after(start) && reserved.end.before(end))) {
                    System.out.println(apartment.getType() + ", " + apartment.host.getName()
                            + " is booked, for these dates. Try another apartment or dates.");
                    return false;
                }
            }
        }
        System.out.println(apartment.getType() + ", " + apartment.host.getName() + " booked successfully.");
        return true;
    }

    public void printReservationDates() {
        for(ReservationDates dates : reservationDates) {
            System.out.print("Reserved from: " + dates.start.get(Calendar.DAY_OF_MONTH) + ", " + dates.start.get(Calendar.MONTH) + ", " + dates.start.get(Calendar.YEAR));
            System.out.println(" to: " + dates.end.get(Calendar.DAY_OF_MONTH) + ", " + dates.end.get(Calendar.MONTH) + ", " + dates.end.get(Calendar.YEAR));
        }
    }

     public void makeReservation(GregorianCalendar start, GregorianCalendar end, Apartment apartment) throws IOException {
         if (isDatesAvailable(start, end, apartment)) {
             reservationDates.add(new ReservationDates(start, end, apartment));
             BookingLog(start, end, "Successful ");
         }
         else BookingLog(start, end, "Failed     ");
     }

    private void BookingLog(GregorianCalendar start, GregorianCalendar end, String message) throws IOException {
        PrintWriter fileOutputStream = null;
        try {
            fileOutputStream = new PrintWriter(new FileWriter("BookingLog.txt", true));
            String s = message + "reservation from: "
                    + start.get(Calendar.DAY_OF_MONTH) + ", " + start.get(Calendar.MONTH) + ", " + start.get(Calendar.YEAR) + " to: "
                    + end.get(Calendar.DAY_OF_MONTH) + ", " + end.get(Calendar.MONTH) + ", " + end.get(Calendar.YEAR) + " ";
            fileOutputStream.println(s);
        } finally {
            fileOutputStream.close();
        }
    }
}