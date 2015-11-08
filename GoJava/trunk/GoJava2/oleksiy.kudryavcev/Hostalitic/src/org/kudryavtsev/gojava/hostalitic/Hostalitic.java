package org.kudryavtsev.gojava.hostalitic;

import java.util.ArrayList;
import java.util.List;

import org.kudryavtsev.gojava.hostalitic.menu.MainMenu;

public final class Hostalitic {

    public static List<Client> clients;
    public static List<Activity> activities;
    public static List<Service> services;

    private Hostalitic() {
	System.out.println("Hostalitic starting...");
	clients = new ArrayList<Client>();
	services = new ArrayList<Service>();
	activities = new ArrayList<Activity>();
	new MainMenu();
    }

    public static void main(final String[] args) {
	Hostalitic system = new Hostalitic();
	fillDemoData(system);
	org.kudryavtsev.gojava.hostalitic.menu.MainMenu.show();
    }

    private static void fillDemoData(Hostalitic system) {

	System.out.println("Demo starting...");
	
	Client client1 = new Client("Max");
	Client client2 = new Client("Misha");

	clients.add(client1);
	clients.add(client2);

	Activity activity1 = new Activity("Hosting");
	Activity activity2 = new Activity("Domain registering");

	activities.add(activity1);
	activities.add(activity2);

	Service service1 = new Service("Provide hosting", activity1);
	Service service2 = new Service("Domain", activity2);

	services.add(service1);
	services.add(service2);

	client1.addService(service1);
	client1.addService(service2);
	client2.addService(service1);
    }
}
