package airbnb;

//import airbnb.common.Observer;
import airbnb.common.Subject;

import java.util.*;

import airbnb.model.Client;
import airbnb.model.Host;
//import airbnb.model.RentType;
import airbnb.model.RentType;
import airbnb.model.User;
import airbnb.reservation.Book;

public class HomeHire implements Subject {
//    private RentType rent;
//    private String city;
    private List<User> hosts = new ArrayList<>();
    private List<User> clients = new ArrayList<>();
    private Set<Book> cities = new HashSet<>();

    public void register(User user) {
        if (user.getClass() == Client.class) {
            Client client = (Client) user;
            if (client.validate()) {
                clients.add(client);
            } else {
                System.out.println("Please enter valid data");
            }
        } else if (user.getClass() == Host.class) {
            Host host = (Host) user;
            if (host.validate()) {
                hosts.add(host);
                if (cities.add(new Book(host.getCity()))) {///???
                    notifyAll("We have new city: " + host.getCity());
                }
                addToBook(host);
            } else {
                System.out.println("Please enter valid data");
            }
        } else {
            System.out.println("Something wrong");
        }
    }

    private void addToBook(Host host) {
        RentType rent = host.getRent();
        String city = host.getCity();
        for (Book book: cities) {
            if (book.getCity().equals(city)) {
                switch (rent) {
                    case PLACE: book.addPlace(host.getUserID());
                    case ROOM: book.addRoom(host.getUserID());
                    case APARTMENT: book.addApartment(host.getUserID());
                }
            }
        }
    }

    public void remove(String surname) {
        Iterator<User> it = hosts.iterator();
        while (it.hasNext()) {
            User user = it.next();
            if(user.getSurname().equals(surname)) {
                it.remove();
            }
            removeFromBook(user);
        }
        it = clients.iterator();
        while (it.hasNext()) {
            User user = it.next();
            if(user.getSurname().equals(surname)) {
                it.remove();
            }
        }
    }

    private void removeFromBook(User user) {
        for (Book book: cities) {
            book.removePlace(user.getUserID());
            book.removeRoom(user.getUserID());
            book.removeApartment(user.getUserID());
        }
    }

    public void notifyAll(String data) {
        for (User user: hosts) user.update(data);
        for (User user: clients) user.update(data);
    }
}
