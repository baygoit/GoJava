package org.kudryavtsev.gojava.hostalitic;

import java.util.List;

public class Client {
    private String clientName;
    private int clientId;
    private Contacts contacts;
    private String clientDescription;
    private List services;
    private boolean debtor;

    public Client(final String userName) {
	setName(userName);
	clientDescription = "Cool client!";
	debtor = false;
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
		+ ", debtor: " + debtor + "; + some other properties.";
    }

}
