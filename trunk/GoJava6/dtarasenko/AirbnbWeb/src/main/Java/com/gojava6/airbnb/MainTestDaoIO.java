package com.gojava6.airbnb;


import com.gojava6.airbnb.dao.io.ApartmentDaoIO;
import com.gojava6.airbnb.dao.io.ReservationDaoIO;
import com.gojava6.airbnb.dao.io.UserDaoIO;
import com.gojava6.airbnb.model.Apartment;
import com.gojava6.airbnb.model.Reservation;
import com.gojava6.airbnb.model.User;

import java.util.List;

public class MainTestDaoIO {

    public static void main(String[] args) {

//        User user = new User();
//        user.setUserId(6);
//        user.setName("Dima");
//        user.setSurname("Tarasenko");
//        user.setEmail("dima.tarasenko@gmail.com");
//        user.setUserType("host");

        UserDaoIO userDaoIO = new UserDaoIO();
//        User user1 = userDaoIO.getUser(5);

//        userDaoIO.createUser(user);
//        userDaoIO.createUser(user);
//        userDaoIO.createUser(user);
//        userDaoIO.createUser(user);
//        userDaoIO.createUser(user);
//        userDaoIO.createUser(user);

//        userDaoIO.deleteUser(user1);
//        userDaoIO.updateUser(user);

        List<User> userList = userDaoIO.getUserList();
        for (User userFromDB : userList) {
            System.out.println(userFromDB.toString());
        }

        System.out.println();

//        Apartment apartment = new Apartment();
//        apartment.setCity("Berlin");
//        apartment.setApartmentType("room");
//        apartment.setUserId(6);

        ApartmentDaoIO apartmentDaoIO = new ApartmentDaoIO();
//        apartmentDaoIO.createApartment(apartment);
//        apartmentDaoIO.createApartment(apartment);
//        apartmentDaoIO.createApartment(apartment);
        Apartment apartment = apartmentDaoIO.getApartment(6);
//        apartment.setCity("Lisabon");
//        apartment.setCity("apartment");

//        apartmentDaoIO.deleteApartment(apartment);
//        apartmentDaoIO.updateApartment(apartment);


        List<Apartment> apartmentList = apartmentDaoIO.getApartmentList();
        for (Apartment apartment1 : apartmentList) {
            System.out.println(apartment1.toString());
        }


        System.out.println();

        ReservationDaoIO reservationDaoIO = new ReservationDaoIO();
        List<Reservation> reservationList = reservationDaoIO.getReservationList();

        for (Reservation reservation : reservationList) {
            System.out.println(reservation.toString());
        }

        List<Reservation> apartmentReservationList = reservationDaoIO.getApartmentReservationList(4);
        for (Reservation reservation : apartmentReservationList) {
            System.out.println(reservation.toString());
        }


    }
}
