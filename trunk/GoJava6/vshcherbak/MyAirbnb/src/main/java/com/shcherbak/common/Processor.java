package com.shcherbak.common;

import com.shcherbak.model.Apartment;
import com.shcherbak.model.old.RentType;
import com.shcherbak.model.User;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface Processor {
    //void openDataBase();
    //void closeDataBase();
    void addUser(User user);
    void removeUser(int user_id);
    void addApartment(Apartment apartment);
    void removeApartment(int id);
    void addReservation(int apartmentID, int clientID, Date start, Date end);
    void removeReservation(int reservation_id);
    void removeReservations(Date date);
    List<Apartment> search(String city, RentType rent, Date start, Date end) throws ParseException;
    void setNotify(int user_id);
    void unSetNotify(int user_id);
    List<String> getNotifyEmails(String kind); // kind = All, notify, client, host
}
