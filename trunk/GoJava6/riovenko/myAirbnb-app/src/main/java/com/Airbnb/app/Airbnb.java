package com.Airbnb.app;
import java.util.List;
import java.util.ArrayList;


/**
 * Created by romanroma on 26.09.15.
 */
public class Airbnb implements Subject {

    public List<Host> hostList = new ArrayList<Host>();
    public List<Client> clientList = new ArrayList<Client>();

    public void registerHost (Host host){
        if (host==null){
            System.out.println("Host not registered");
        }
        else hostList.add(host);
    }

    public void registerClient (Client client){
        //User client = new Client (name,surname,email);
        if (client==null){
            System.out.println("Client not registered");
        }
        else clientList.add(client);
    }

    public void remove (Host host){
        hostList.remove(host);
    }

    public void remove (Client client){
        clientList.remove(client);
    }

    public void notifyAllClients (String message){
        for (Observer observer : clientList){
            observer.update("NOTIFY");
        }
    }


}
