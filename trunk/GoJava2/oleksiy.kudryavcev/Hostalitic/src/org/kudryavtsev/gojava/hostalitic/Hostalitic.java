package org.kudryavtsev.gojava.hostalitic;

import org.kudryavtsev.gojava.hostalitic.menu.Menu;
import org.kudryavtsev.gojava.hostalitic.reports.Report;

public final class Hostalitic {

    // private static Menu menu;

    private Hostalitic() {
	System.out.println("Hostalitic starting...");
    }

    public static void main(final String[] args) {
	Hostalitic hostalitic = new Hostalitic();

	User user1 = new User("Sasha");
	hostalitic.addUser(user1);

	Activity activity1 = new Activity("Hosting");
	hostalitic.addActivity(activity1);

	Service service1 = new Service("IP address");
	hostalitic.addService(activity1, service1);

	Report report1 = new Report(user1);
	report1.show("User info");

	Menu mainMenu = new Menu();
	mainMenu.showMenu();

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

    private void addUser(final User user) {
	// System.out.println("Enter user name: ");
	// return (new Scanner(System.in).nextLine());
	// TODO implement add user
	System.out.println("User " + user.getName() + " added.");
    }

}
