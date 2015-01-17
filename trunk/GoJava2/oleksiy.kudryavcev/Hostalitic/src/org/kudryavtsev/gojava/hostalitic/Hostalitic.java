package org.kudryavtsev.gojava.hostalitic;

import java.util.Scanner;

public class Hostalitic {

    public static void main(String[] args) {
	Hostalitic hostalitic = new Hostalitic();

	User user1 = new User("Sasha");
	hostalitic.addUser(user1);

	Activity activity1 = new Activity("Hosting");
	hostalitic.addActivity(activity1);

	Service service1 = new Service("IP address");
	hostalitic.addService(activity1, service1);

    }

    private void addService(Activity activity, Service service) {
	System.out.println("Service " + service.getName() + 
		" for activity " + activity.getName() + " added.");

    }

    private void addActivity(Activity activity) {
	// TODO implement add activity
	System.out.println("Activity " + activity.getName() + " added.");
    }

    private void addUser(User user) {
	// System.out.println("Enter user name: ");
	// return (new Scanner(System.in).nextLine());
	// TODO implement add user
	System.out.println("User " + user.getName() + " added.");
    }

}
