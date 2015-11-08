package org.kudryavtsev.gojava.hostalitic;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String clientName;
    private int clientId;
    private Contacts contacts;
    private String clientDescription;
    private List<Service> services;
    private boolean debtor;

    public Client(final String userName) {
	setName(userName);
	clientDescription = "Cool client!";
	debtor = false;
	services = new ArrayList<Service>();
	System.out.println("Client " + this.getName() + " created.");
    }

    public final String getName() {
	return clientName;
    }

    private void setName(final String newName) {
	clientName = newName;
    }

    @Override
    public String toString() {
	return "Client: " + clientName + "; desc: " + clientDescription
		+ ", debtor: " + debtor + ", services: " + getServices() + "; + some other properties.";
    }

    public List<Service> getServices() {
	return services;
    }

   public void addService(Service newService) {
	services.add(newService);
    }

}
