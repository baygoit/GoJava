package airbnb;

import airbnb.common.Subject;
import airbnb.model.RentType;
import airbnb.reservation.Apartment;
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

    public void register(User user) {
        if (user.validate()) {
            users.add(user);
        } else {
            System.out.println("Please enter valid data");
        }
        if (user instanceof Host) {
            Host host = (Host) user;
            addToApartment(host);
        }
    }

    public boolean clientToHost(String surname, String city, RentType rent) {
        for (User user: users) {
            if (user.getSurname() == surname) {
                if (user instanceof Client) {
                    Client client = (Client) user;
                    Host host = new Host(client.getName(), client.getSurname(), client.getEmail(), city, rent);
                    users.add(host);
                    addToApartment(host);
                    return true;
                }
            }
        }
        return false;
    }

    private void addToApartment(Host host) {
        apartments.add(new Apartment(host.getUserID(), host.getRent(), host.getCity()));
        if (cities.add(host.getCity())) {
            notifyAll("We have new city: " + host.getCity());
        }
    }

    public void remove(String surname) {
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User user = it.next();
            if(user.getSurname().equals(surname)) {
                if (user instanceof Host) {
                    Host host = (Host) user;
                    removeFromApartment(host);
                }
                it.remove();
            }
        }
    }

    private void removeFromApartment(Host host) {
        for (Apartment apartment : apartments) {
            if (apartment.getHostID() == host.getUserID()) { apartments.remove(apartment); }
        }
    }

    public int search( String city, RentType rent, String startString, String endString ) throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
        Date start = dt.parse(startString);
        Date end = dt.parse(endString);
        for ( Apartment apartment: apartments ) {
            if ( apartment.getRent() == rent && apartment.getCity() == city ) {
                if ( apartment.isAvailable(start, end) ) {
                    apartment.makeReservation(1, start, end);
                    return apartment.getApartmentID();
                }
            }
        }
        return -1;
    }

    public void notifyAll(String data) {
        for (User user: users) user.update(data);
    }

    public void notifyHosts(String data) {
        for (User user: users) {
            if (user instanceof Host) {
                Host host = (Host) user;
                host.update(data);
            }
        }
    }

    public void notifyClients(String data) {
        for (User user: users) {
            if (user instanceof Client) {
                Client client = (Client) user;
                client.update(data);
            }
        }
    }

    public void getAllApartment() {
        for ( Apartment apartment: apartments ) {
            System.out.println(apartment);
        }
    }
}