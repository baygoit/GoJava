package com.donishchenko.airbnb;

import com.donishchenko.airbnb.common.Subject;
import com.donishchenko.airbnb.managers.*;
import com.donishchenko.airbnb.model.*;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

public class SortOfHomeController implements Subject<User> {
    private UserManager userManager = new UserManagerImpl();
    private ApartmentManager apartmentManager = new ApartmentManagerImpl();
    private ReservationManager reservationManager = new ReservationManagerImpl();

    public int addClient(String name, String surname, String email) {
        User client = new Client(name, surname, email);
        if (client.validate()) {
            System.out.println("INFO: ClientID=" + client.getId() + " | Successful validation!");
            userManager.saveClient(client);
            return client.getId();
        }

        return -1;
    }

    public int addHost(String name, String surname, String email) {
        User host = new Host(name, surname, email);
        if (host.validate()) {
            System.out.println("INFO: HostID=" + host.getId() + " | Successful validation!");
            userManager.saveHost(host);
            return host.getId();
        }

        return -1;
    }

    public void deleteClient(int id) {
        userManager.deleteClient(id);
    }

    public void deleteHost(int id) {
        userManager.deleteHost(id);
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
        Collection<User> set = SortOfDataBase.clients.values();
        for (User user : set) {
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
            apartmentManager.save(apartment);
            return apartment.getId();
        }

        return -1;
    }

    private void checkUniqueCity(String city) {
        if (SortOfDataBase.uniqueCities.add(city)) {
            for (User user : SortOfDataBase.clients.values()) {
                user.update("Hey! We have new available city - " + city + "!");
            }
        }
    }

    /* Test main */
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
        for (Apartment ap : mainApp.apartmentManager.getAll()) {
            System.out.println("\t" + ap);
        }

        /* Reservation system */
        User user = mainApp.userManager.getClientById(clientId);
        Apartment apartment = mainApp.apartmentManager.getById(apartmentId);
        Date start = new GregorianCalendar(2015, Calendar.SEPTEMBER, 26).getTime();
        Date end = new GregorianCalendar(2015, Calendar.SEPTEMBER, 27).getTime();

        mainApp.reservationManager.makeReservation(user, apartment, start, end, "Thank you!");

        start = new GregorianCalendar(2015, Calendar.SEPTEMBER, 30).getTime();
        end = new GregorianCalendar(2015, Calendar.OCTOBER, 5).getTime();
        mainApp.reservationManager.makeReservation(user, apartment, start, end, "Pleeeeaaaaase");

        start = new GregorianCalendar(2015, Calendar.SEPTEMBER, 28).getTime();
        end = new GregorianCalendar(2015, Calendar.SEPTEMBER, 29).getTime();
        mainApp.reservationManager.makeReservation(user, apartment, start, end, "Pleeeeaaaaase");
    }
}
