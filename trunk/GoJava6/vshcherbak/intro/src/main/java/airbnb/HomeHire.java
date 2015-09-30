package airbnb;
/**
 * Created by slavik on 21.09.2015.
 */
//import airbnb.common.Observer;
import airbnb.common.Subject;

import java.util.*;

import airbnb.model.Client;
import airbnb.model.Host;
//import airbnb.model.RentType;
import airbnb.model.User;

public class HomeHire implements Subject {

    private List<User> hosts = new ArrayList<>();
    private List<User> clients = new ArrayList<>();
    private Set<String> cities = new HashSet<>();

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
                if (cities.add(host.getCity())) {
                    notifyAll("We have new city: " + host.getCity());
                }
            } else {
                System.out.println("Please enter valid data");
            }
        } else {
            System.out.println("Something wrong");
        }
    }

    public void remove(String surname) {
        Iterator<User> it = hosts.iterator();
        while (it.hasNext()) {
            User u = it.next();
            if(u.getSurname().equals(surname)) {
                it.remove();
            }
        }
        it = clients.iterator();
        while (it.hasNext()) {
            User u = it.next();
            if(u.getSurname().equals(surname)) {
                it.remove();
            }
        }
    }

    public void notifyAll(String data) {
        for (User user: hosts) user.update(data);
        for (User user: clients) user.update(data);
    }
}
