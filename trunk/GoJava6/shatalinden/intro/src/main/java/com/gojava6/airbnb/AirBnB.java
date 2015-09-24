package com.gojava6.airbnb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shata on 17.09.2015.
 */
public class AirBnB implements Subject{

    public AirBnB() {
    }
    private List<Host> hostList = new ArrayList<Host>();
    private List<Client> clientList = new ArrayList<Client>();
    private Set<String> cities = new HashSet<String>();

    public void notifyClients(String message) {
        for(Client client : clientList) {
            client.update("New city: " + message + " for " + client.getName());
        }
    }

    public void register(Host host) {
        if(host==null) {
            System.out.println("Host not registered.");
        }
        else hostList.add(host);
        if(cities.add(host.getCity())) {
            notifyClients(host.getCity());
        }
    }

    public void register(Client client) {
        if(client==null) {
            System.out.println("Host not registered.");
        }
        else clientList.add(client);
    }

    public void remove(Host host) {
        hostList.remove(host);
    }

    public void remove(Client client) {

        clientList.remove(client);
    }

}
