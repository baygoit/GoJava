package com.gojava6.airbnb.reservation;

import com.gojava6.airbnb.apartment.Apartment;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by sergiigetman on 9/23/15.
 */
public class Book {

//    make isDateAvailable shorter

    private boolean isDatesAvailable(Date start, Date end, Apartment apartment) {
        for (ReservationDates reserved : apartment.reservationDates) {
            if (reserved.apartment == apartment) {
                if ((start.after(reserved.start) && start.before(reserved.end))) {
                    System.out.println(apartment.getType() + ", " + apartment.user.getName()
                            + " is booked, for these dates. Try another apartment or dates.");
                    return false;
                }
                if ((end.after(reserved.start) && end.before(reserved.end))) {
                    System.out.println(apartment.getType() + ", " + apartment.user.getName()
                            + " is booked, for these dates. Try another apartment or dates.");
                    return false;
                }
                if ((reserved.start.after(start) && reserved.start.before(end))) {
                    System.out.println(apartment.getType() + ", " + apartment.user.getName()
                            + " is booked, for these dates. Try another apartment or dates.");
                    return false;
                }
                if ((reserved.end.after(start) && reserved.end.before(end))) {
                    System.out.println(apartment.getType() + ", " + apartment.user.getName()
                            + " is booked, for these dates. Try another apartment or dates.");
                    return false;
                }
            }
        }
        System.out.println(apartment.getType() + ", " + apartment.user.getName() + " booked successfully.");
        return true;
    }

    public void printReservationDates(Apartment apartment) {
        for(ReservationDates dates : apartment.reservationDates) {
            System.out.print("Reserved from: " + dates.start.getDate() + ", " + dates.start.getMonth()+ ", " + dates.start.getYear());
            System.out.println(" to: " + dates.end.getDate() + ", " + dates.end.getMonth() + ", " + dates.end.getYear());
        }
    }

    public void makeReservation(Date start, Date end, Apartment apartment) throws IOException, NullPointerException {
         if (apartment.user == null) throw new NullPointerException("Apartment and host are not available.");
         if (isDatesAvailable(start, end, apartment)) {
             apartment.reservationDates.add(new ReservationDates(start, end, apartment));
             BookingLog(apartment, start, end, "Successful. ");
         }
         else BookingLog(apartment, start, end, "Failed. ");
    }

    private void BookingLog(Apartment apartment, Date start, Date end, String message) {
        try(PrintWriter fileOutputStream = new PrintWriter(new FileWriter("BookingLog.txt", true))) {
            String s = message + apartment.city + ". Host: " + apartment.user.getName() + ". " + apartment.getType()
                    + ".\n\tDates from: "
                    + start.getDate() + ", " + start.getMonth() + ", " + start.getYear() + " to: "
                    + end.getDate() + ", " + end.getMonth() + ", " + end.getYear() + ".\n\t"
                    + "Time of request - " + new Date() + ".";
            fileOutputStream.println(s);
        } catch (IOException e) {
            System.out.println("Input output error: " + e);
        }
    }
}