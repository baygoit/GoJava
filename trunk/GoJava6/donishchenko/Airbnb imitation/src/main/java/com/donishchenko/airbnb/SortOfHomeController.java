package com.donishchenko.airbnb;

import com.donishchenko.airbnb.common.Subject;
import com.donishchenko.airbnb.dao.*;
import com.donishchenko.airbnb.model.*;
import com.google.common.base.Joiner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SortOfHomeController implements Subject<User> {
    public static final Logger log = LogManager.getLogger(SortOfHomeController.class.getName());

    private UserDao userDao = new UserDaoImpl();
    private ApartmentDao apartmentDao = new ApartmentDaoImpl();
    private ReservationDao reservationDao = new ReservationDaoImpl();

    public int addClient(String name, String surname, String email) {
        log.entry();

        User client = new Client(name, surname, email);
        if (client.validate()) {
            log.info("ClientID=" + client.getId() + " | Successful validation. New User registered!");
            userDao.saveClient(client);

            log.exit(client.getId());
            return client.getId();
        }

        log.exit(-1);
        return -1;
    }

    public int addHost(String name, String surname, String email) {
        log.entry();

        User host = new Host(name, surname, email);
        if (host.validate()) {
            log.info("HostID=" + host.getId() + " | Successful validation. New Host registered!");
            userDao.saveHost(host);

            log.exit(host.getId());
            return host.getId();
        }

        log.exit(-1);
        return -1;
    }

    public void deleteClient(int id) {
        userDao.deleteClient(id);
    }

    public void deleteHost(int id) {
        userDao.deleteHost(id);
    }

    @Override
    public void register(User user) {
        SortOfDataBase.clients.put(user.getId(), user);
    }

    @Override
    public void remove(User user) {
        SortOfDataBase.clients.remove(user.getId());
    }

    @Override
    public void notifyAllObservers(String message) {
        List<User> list = userDao.getAllClients();
        for (User user : list) {
            user.update(message);
        }
    }

    public int createApartment(int hostId, String city, ApartmentType type, boolean active) {
        if (hostId < 1) {
            return -1;
        }

        Host existingHost = (Host) SortOfDataBase.hosts.get(hostId);
        if (existingHost == null) {
            return -1;
        }

        Apartment apartment = new Apartment(existingHost, city, type, active);
        if (apartment.validate()) {
            checkUniqueCity(apartment.getCity());
            apartmentDao.save(apartment);
            return apartment.getId();
        }

        return -1;
    }

    private void checkUniqueCity(String city) {
        if (SortOfDataBase.uniqueCities.add(city)) {
            notifyAllObservers("\n\tHey! We have new available city - " + city + "!");
        }
    }

    /* Test main. Request simulation */
    public static void main(String[] args) {
        SortOfHomeController mainApp = new SortOfHomeController();

        /* Clients */
        int clientId = mainApp.addClient("Dmitry", "Onishchenko", "sacr8tum@gmail.com");
        mainApp.addClient("Carl-Vicoria", "Bukovski", "c-v.bukovski@i.ua");
        mainApp.addClient("Katarina", "Gorava-Zhdanova", "kat1965@bigmir.net");
        mainApp.addClient("Ali", "Gur-Sabn-Al-Bin-Sourcevich", "g.s.a.b.s@gmail.com");
        System.out.println();

        /* Hosts */
        int hostId = mainApp.addHost("John", "Doe", "j.doe-superman@gmail.com");
        System.out.println();

        /* Apartments */
        int apartmentId = mainApp.createApartment(hostId, "Kiev", ApartmentType.APARTMENT, true);
        mainApp.createApartment(hostId, "Kiev", ApartmentType.APARTMENT, true);

        System.out.println("\nAll apartments:");
        for (Apartment ap : mainApp.apartmentDao.getAll()) {
            System.out.println("\t" + ap);
        }
        System.out.println();

        /* Reservation system */
        /* Test three reservations: 2 true, 1 false */
        User user = mainApp.userDao.getClientById(clientId);
        Apartment apartment = mainApp.apartmentDao.getById(apartmentId);
        Date start = new GregorianCalendar(2015, Calendar.SEPTEMBER, 26).getTime();
        Date end = new GregorianCalendar(2015, Calendar.SEPTEMBER, 27).getTime();

        mainApp.testReservation(user, apartment, start, end, "Thank you!");

        start = new GregorianCalendar(2015, Calendar.SEPTEMBER, 30).getTime();
        end = new GregorianCalendar(2015, Calendar.OCTOBER, 5).getTime();
        mainApp.testReservation(user, apartment, start, end, "Pleeeeaaaaase");

        start = new GregorianCalendar(2015, Calendar.SEPTEMBER, 27).getTime();
        end = new GregorianCalendar(2015, Calendar.SEPTEMBER, 29).getTime();
        mainApp.testReservation(user, apartment, start, end, "so?");

        /* All reservations */
        System.out.println("\nAll reservations:");
        List<Reservation> list = mainApp.reservationDao.getAll();
        for (Reservation reservation : list) {
            System.out.print('\t');
            System.out.println(reservation);
        }

        /* Custom reservations between two dates */
        start = new GregorianCalendar(2015, Calendar.SEPTEMBER, 26).getTime();
        end = new GregorianCalendar(2015, Calendar.SEPTEMBER, 30).getTime();
        list = mainApp.reservationDao.getAllBetweenDates(start, end);
        System.out.println("\nCustom reservations");
        for (Reservation reservation : list) {
            System.out.print('\t');
            System.out.println(reservation);
        }
    }

    private void testReservation(User user, Apartment apartment, Date start, Date end, String comment) {
        if (log.isInfoEnabled()) {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy");
            log.info(Joiner.on("").join("Started reservation request: UserID='", user.getId(),
                    "', apartmentID='", apartment.getId(), "', start='", format.format(start),
                    "', end='", format.format(end), "'"));
        }
        reservationDao.makeReservation(user, apartment, start, end, comment);
    }
}
