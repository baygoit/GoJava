package airbnb;

import airbnb.accounting.Booking;
import airbnb.accounting.ReservationDates;
import airbnb.common.Subject;
import airbnb.model.RentType;
import airbnb.model.Apartment;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import airbnb.model.User;
import airbnb.model.Host;
import airbnb.model.Client;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeHire implements Subject {
    private List<User> users = new ArrayList<>();
    private Set<String> cities = new HashSet<>();
    private Set<Apartment> apartments = new HashSet<>();
    private Booking book = new Booking(apartments);
    private Registration delivery = new Registration(users);

    public void register(User user) {
        if (user.validate()) {
            users.add(user);
        } else {
            System.out.println("Please enter valid data");
        }
        if (user instanceof Client) {
            delivery.addToNotify(user);
        }
    }

    public boolean clientToHost(String surname) {
        for (User user: users) {
            if (user.getSurname() == surname) {
                if (user instanceof Client) {
                    Client client = (Client) user;
                    Host host = new Host(client.getName(), client.getSurname(), client.getEmail());
                    users.add(host);
                    return true;
                }
            }
        }
        return false;
    }

    private void addApartment(Host host, RentType rent, String city) {
        Apartment apartment = new Apartment(host.getUserID(), rent, city);
        apartments.add(apartment);
        host.addApartment(apartment.getApartmentID());
        if (cities.add(city)) {
            delivery.update("We have new city: " + city);
        }
    }

    public void remove(String surname) {
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User user = it.next();
            if(user.getSurname().equals(surname)) {
                if (user instanceof Host) {
                    Host host = (Host) user;
                    removeApartment(host);
                }
                it.remove();
            }
        }
    }

    private void removeApartment(Host host) {
        Iterator<Apartment> it = apartments.iterator();
        while (it.hasNext()) {
            Apartment apartment = it.next();
            if(apartment.getHostID() == host.getUserID()) {
                book.delAllApartmentReservation(apartment.getApartmentID());
                it.remove();
            }
        }
    }

    public void getAllApartment() {
        for ( Apartment apartment: apartments ) {
            System.out.println(apartment);
        }
    }

    public static void main(String[] args) throws ParseException {
        HomeHire hire = new HomeHire();
        User user =  new Client("Jon", "Scott", "scott@site.com");
        hire.register(user);
        user =  new Client("Dylan", "Robinson", "robinson@site.com");
        hire.register(user);
        user = new Host("Brenda", "Taylor", "taylor@site.com");
        hire.register(user);
        user =  new Host("Donna", "Small", "small@site.com");
        hire.register(user);
        user =  new Host("Angle", "Baker", "baker@site.com");
        hire.register(user);

        hire.delivery.notifyAll("ready");
        hire.remove("Small");
        hire.delivery.notifyAll("minus one");

        int id = hire.book.search("Kiev", RentType.ROOM, "2015-10-05", "2015-10-10");
        System.out.println(id);
        id = hire.book.search("Kiev", RentType.APARTMENT, "2015-10-05", "2015-10-10");
        System.out.println(id);
        id = hire.book.search("Odessa", RentType.PLACE, "2015-10-05", "2015-10-10");
        System.out.println(id);
        id = hire.book.search("Kiev", RentType.PLACE, "2015-10-05", "2015-10-10");
        System.out.println(id);

        hire.getAllApartment();
    }
}