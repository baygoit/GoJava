package airbnb;

import airbnb.common.Subject;
import airbnb.reservation.Apartment;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import airbnb.model.User;
import airbnb.model.Host;
import airbnb.model.Client;

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
            if (cities.add(host.getCity())) {///???
                notifyAll("We have new city: " + host.getCity());
            }
        }
    }

    private void addToApartment(Host host) {
        apartments.add(new Apartment(host.getUserID(), host.getRent(), host.getCity()));
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
}