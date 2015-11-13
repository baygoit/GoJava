package com.donishchenko.airbnb;

import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.ApartmentType;
import com.donishchenko.airbnb.model.User;
import com.donishchenko.airbnb.services.UserService;
import com.google.common.base.Joiner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SortOfHomeController {
    public static final Logger log = LogManager.getLogger(SortOfHomeController.class.getName());

    private UserService userService = new UserService();

    public void registerUser(String name, String surname, String email, boolean isHost) {
//        userService.register(name, surname, email, isHost);
    }

    public void deleteUser(int id) {
        userService.deleteUser(id);
    }

    public void deleteUser(User user) {
        userService.deleteUser(user.getId());
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public List<User> getAllClients() {
        return userService.getAllClients();
    }

    public List<User> getAllHosts() {
        return userService.getAllHosts();
    }

    public int createApartment(int hostId, String city, ApartmentType type, boolean active) {
        if (hostId < 1) {
            return -1;
        }

        User existingHost = SortOfDataBase.hosts.get(hostId);
        if (existingHost == null) {
            return -1;
        }

        Apartment apartment = new Apartment(existingHost, city, type, active);
//        if (apartment.validate()) {
//            checkUniqueCity(apartment.getCity());
////            apartmentDao.save(apartment);
//            return apartment.getId();
//        }

        return -1;
    }

    private void checkUniqueCity(String city) {
        if (SortOfDataBase.uniqueCities.add(city)) {
//            notifyAllObservers("\n\tHey! We have new available city - " + city + "!");
        }
    }

    /* Test main. Request simulation */
    public static void main(String[] args) {
        SortOfHomeController app = new SortOfHomeController();

        /* Clients */
        app.registerUser("Dmitry", "Onishchenko", "sacr8tum@gmail.com", false);
        app.registerUser("Carl-Vicoria", "Bukovski", "c-v.bukovski@i.ua", false);
        app.registerUser("Katarina", "Gorava-Zhdanova", "kat1965@bigmir.net", false);
        app.registerUser("Ali", "Gur-Sabn-Al-Bin-Sourcevich", "g.s.a.b.s@gmail.com", false);
        System.out.println();

        /* Hosts */
        app.registerUser("John", "Doe", "j.doe-superman@gmail.com", true);
        System.out.println();

        List<User> list = app.getAllUsers();
        for (User user : list) {
            System.out.println(user);
        }

        /* Apartments */
//        int apartmentId = app.createApartment(hostId, "Kiev", ApartmentType.APARTMENT, true);
//        app.createApartment(hostId, "Kiev", ApartmentType.APARTMENT, true);
//
//        System.out.println("\nAll apartments:");
//        for (Apartment ap : app.apartmentDao.getAll()) {
//            System.out.println("\t" + ap);
//        }
//        System.out.println();
//
//        /* Reservation system */
//        /* Test three reservations: 2 true, 1 false */
//        User user = app.userDao.get(clientId);
//        Apartment apartment = app.apartmentDao.get(apartmentId);
//        Date start = new GregorianCalendar(2015, Calendar.SEPTEMBER, 26).getTime();
//        Date end = new GregorianCalendar(2015, Calendar.SEPTEMBER, 27).getTime();
//
//        app.testReservation(user, apartment, start, end, "Thank you!");
//
//        start = new GregorianCalendar(2015, Calendar.SEPTEMBER, 30).getTime();
//        end = new GregorianCalendar(2015, Calendar.OCTOBER, 5).getTime();
//        app.testReservation(user, apartment, start, end, "Pleeeeaaaaase");
//
//        start = new GregorianCalendar(2015, Calendar.SEPTEMBER, 27).getTime();
//        end = new GregorianCalendar(2015, Calendar.SEPTEMBER, 29).getTime();
//        app.testReservation(user, apartment, start, end, "so?");
//
//        /* All reservations */
//        System.out.println("\nAll reservations:");
//        List<Reservation> list = app.reservationDao.getAll();
//        for (Reservation reservation : list) {
//            System.out.print('\t');
//            System.out.println(reservation);
//        }
//
//        /* Custom reservations between two dates */
//        start = new GregorianCalendar(2015, Calendar.SEPTEMBER, 26).getTime();
//        end = new GregorianCalendar(2015, Calendar.SEPTEMBER, 30).getTime();
//        list = app.reservationDao.getAllBetweenDates(start, end);
//        System.out.println("\nCustom reservations");
//        for (Reservation reservation : list) {
//            System.out.print('\t');
//            System.out.println(reservation);
//        }
    }

    private void testReservation(User user, Apartment apartment, Date start, Date end, String comment) {
        if (log.isInfoEnabled()) {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy");
            log.info(Joiner.on("").join("Started reservation request: UserID='", user.getId(),
                    "', apartmentID='", apartment.getId(), "', start='", format.format(start),
                    "', end='", format.format(end), "'"));
        }
//        reservationDao.makeReservation(user, apartment, start, end, comment);
    }
}
