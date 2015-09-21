<<<<<<< HEAD
package com.donishchenko.airbnb;

import com.donishchenko.airbnb.common.Observer;
import com.donishchenko.airbnb.common.Subject;
import com.donishchenko.airbnb.model.ApartmentType;
import com.donishchenko.airbnb.model.Client;
import com.donishchenko.airbnb.model.Host;
import com.donishchenko.airbnb.model.User;

import java.util.HashSet;
import java.util.Set;

public class MainApp implements Subject {
    private Set<Observer> clients = new HashSet<>();
    private Set<User> hosts = new HashSet<>();

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();

        mainApp.addClient("Dmitry", "Onishchenko", "sacr8tum@gmail.com");
        mainApp.addClient("Carl-Vicoria", "Bukovski", "c-v.bukovski@i.ua");
        mainApp.addClient("Katarina", "Gorava-Zhdanova", "kat1965@bigmir.net");
        mainApp.addClient("Ali", "Gur-Sabn-Al-Bin-Sourcevich", "g.s.a.b.s@gmail.com");

        User host = new Host("John", "Doe", "j.doe-superman@gmail.com", "Kiev", ApartmentType.PLACE);
        if (host.validate()) {
            System.out.println("True host!");
            mainApp.addHost(host, true);
        }


    }

    public void addClient(String name, String surname, String email) {
        User client = new Client(name, surname, email);
        if (client.validate())
            clients.add(client);
    }

    public void addHost(User host, boolean notifyAll) {
        hosts.add(host);
        if (notifyAll)
            notifyAllObservers("Hey! We have new host! " + host.toString());
    }

    @Override
    public void register(Observer o) {
        clients.add(o);
    }

    @Override
    public void remove(Observer o) {
        clients.remove(o);
    }

    @Override
    public void notifyAllObservers(String message) {
        for (Observer observer : clients) {
            observer.update(message);
        }
    }
}
=======
package com.donishchenko.airbnb;

import com.donishchenko.airbnb.common.Observer;
import com.donishchenko.airbnb.common.Subject;
import com.donishchenko.airbnb.model.ApartmentType;
import com.donishchenko.airbnb.model.Client;
import com.donishchenko.airbnb.model.Host;
import com.donishchenko.airbnb.model.User;

import java.util.HashSet;
import java.util.Set;

public class MainApp implements Subject {
    private Set<Observer> clients = new HashSet<>();
    private Set<User> hosts = new HashSet<>();

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();

        mainApp.addClient("Dmitry", "Onishchenko", "sacr8tum@gmail.com");
        mainApp.addClient("Carl-Vicoria", "Bukovski", "c-v.bukovski@i.ua");
        mainApp.addClient("Katarina", "Gorava-Zhdanova", "kat1965@bigmir.net");
        mainApp.addClient("Ali", "Gur-Sabn-Al-Bin-Sourcevich", "g.s.a.b.s@gmail.com");

        User host = new Host("John", "Doe", "j.doe-superman@gmail.com", "Kiev", ApartmentType.PLACE);
        if (host.validate()) {
            System.out.println("True host!");
            mainApp.addHost(host, true);
        }


    }

    public void addClient(String name, String surname, String email) {
        User client = new Client(name, surname, email);
        if (client.validate())
            clients.add(client);
    }

    public void addHost(User host, boolean notifyAll) {
        hosts.add(host);
        if (notifyAll)
            notifyAllObservers("Hey! We have new host! " + host.toString());
    }

    @Override
    public void register(Observer o) {
        clients.add(o);
    }

    @Override
    public void remove(Observer o) {
        clients.remove(o);
    }

    @Override
    public void notifyAllObservers(String message) {
        for (Observer observer : clients) {
            observer.update(message);
        }
    }
}
>>>>>>> b406adcc396a7505479ad772bb83478ed6740c5d
