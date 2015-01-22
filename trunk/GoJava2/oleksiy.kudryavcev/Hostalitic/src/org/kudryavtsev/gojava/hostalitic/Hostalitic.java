package org.kudryavtsev.gojava.hostalitic;

import java.util.ArrayList;
import java.util.List;

import org.kudryavtsev.gojava.hostalitic.menu.Menu;
import org.kudryavtsev.gojava.hostalitic.menu.mainMenu;
import org.kudryavtsev.gojava.hostalitic.reports.Report;

public final class Hostalitic {

    public static List<Client> clients;
    private static List<Activity> activities;
    private static List<Service> services;
    private static mainMenu mainMenu;

    private Hostalitic() {
	System.out.println("Hostalitic starting...");
	clients = new ArrayList<Client>();
	services = new ArrayList<Service>();
	activities = new ArrayList<Activity>();
	mainMenu = new mainMenu();	
    }

    public static void main(final String[] args) {
	Hostalitic hostalitic = new Hostalitic();

	fillDemoData(hostalitic);
	org.kudryavtsev.gojava.hostalitic.menu.mainMenu.show();

    }

    private static void fillDemoData(Hostalitic hostalitic) {
	
	System.out.println("Demo starting...");
	Client client1 = new Client("Max");
	Client client2 = new Client("Misha");
	
	clients.add(client1);
	clients.add(client2);
	
	// for(Client item : clients) {
	// String element = item.toString();
	// System.out.println(element);
	// }

//	Activity activity1 = new Activity("Hosting");
//	hostalitic.addActivity(activity1);
//
//	Service service1 = new Service("IP address");
//	hostalitic.addService(activity1, service1);
//
//	Report report1 = new Report(user1);
//	report1.show("Client info");
    }

    private void addService(final Activity activity, final Service service) {
	// TODO implement add service
	System.out.println("Service " + service.getName() + " for activity "
		+ activity.getName() + " added.");

    }

    private void addActivity(final Activity activity) {
	// TODO implement add activity
	System.out.println("Activity " + activity.getName() + " added.");
    }

    private void addUser(final Client user) {
	// System.out.println("Enter user name: ");
	// return (new Scanner(System.in).nextLine());
	// TODO implement add user
	System.out.println("Client " + user.getName() + " added.");
    }

}
