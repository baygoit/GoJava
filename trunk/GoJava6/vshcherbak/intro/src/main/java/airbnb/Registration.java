package airbnb;

import airbnb.common.Observer;
import airbnb.model.Client;
import airbnb.model.Host;
import airbnb.model.User;

import java.util.ArrayList;
import java.util.List;

public class Registration implements Observer {
    List<User> users;
    private List<User> notify = new ArrayList<>();

    public Registration(List<User> users) {
        this.users = users;
    }

    public void addToNotify (User user) {
        notify.add(user);
    }

    public void removeFromNotify (User user) {
        notify.remove(user);
    }

    public void notifyAll(String data) {
        for (User user: users) {
            System.out.println("Send " + data + " to " + user.getEmail());
        }
    }

    public void notifyHosts(String data) {
        for (User user: users) {
            if (user instanceof Host) {
                System.out.println("Send " + data + "to" + user.getEmail());
            }
        }
    }

    public void notifyClients(String data) {
        for (User user: users) {
            if (user instanceof Client) {
                System.out.println("Send " + data + "to" + user.getEmail());
            }
        }
    }

    public void update(String message) {
        for (User user: notify) {
            System.out.println("Send " + message + " to " + user.getEmail());
        }
    }
}
