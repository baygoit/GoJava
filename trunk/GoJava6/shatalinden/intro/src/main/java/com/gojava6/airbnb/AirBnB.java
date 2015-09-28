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
    private static List<Host> hostList = new ArrayList<Host>();
    private static List<Client> clientList = new ArrayList<Client>();
    private static Set<String> cities = new HashSet<String>();

    @Override
    public void notifyClients(String message) {
        for(Client client : clientList) {
            client.update("New city: " + message + " for " + client.getName());
        }
    }

    @Override
    public void register(Host host) {
        if(host==null) {
            System.out.println("Host not registered.");
        }
        else {
            hostList.add(host);
        }
        if(cities.add(host.getCity())) {
            notifyClients(host.getCity());
        }
    }

    @Override
    public void register(Client client) {
        if(client==null) {
            System.out.println("Client not registered.");
        }
        else {
            clientList.add(client);
        }
    }

    @Override
    public void remove(User user) {
        if (user.getClass().toString()=="Host") {
            hostList.remove(user);
        }
        if (user.getClass().toString()=="Client") {
            clientList.remove(user);
        }
    }

    public void getCityApartments(String city) {
        for (Host host : hostList) {
            if (host.getCity()==city) {
                for (Apartment apartment : host.getApartments()) {
                    System.out.println(host.getCity() + ", " + host.getName() + ": " + apartment.getType());
                }
            }
        }
    }

}