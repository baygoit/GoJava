package com.Airbnb.app;
import com.Airbnb.app.common.Observer;
import com.Airbnb.app.common.Subject;
import com.Airbnb.app.model.Client;
import com.Airbnb.app.model.Host;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by romanroma on 26.09.15.
 */
public class Airbnb implements Subject {

    public List<Host> hostList = new ArrayList<Host>();
    public List<Client> clientList = new ArrayList<Client>();

    public void registerHost (Host host){
        if (host.validation()) {
            hostList.add(host);
        }
        else System.out.println("Please enter valid data");
    }

    public void registerClient (Client client){
        if (client.validation()) {
            clientList.add(client);
        }
        else System.out.println("Please enter valid data");
    }

    public void removeClient (int id){
        clientList.remove(clientList.get(id));
    }

    public void removeHost (int id){
        hostList.remove(hostList.get(id));
    }

    public void notifyAll (String message){
        for (Observer observer : clientList){
            observer.update(message);
        }
        for (Observer observer : hostList){
            observer.update(message);
        }
    }


}
