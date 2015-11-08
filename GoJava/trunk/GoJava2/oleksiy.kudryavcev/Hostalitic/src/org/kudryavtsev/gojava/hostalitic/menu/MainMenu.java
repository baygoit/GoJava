package org.kudryavtsev.gojava.hostalitic.menu;

import java.util.Scanner;

public class MainMenu extends Menu {
    private static Menu clientsMenu;
    private static Menu activitiesMenu;
    private static Menu reportsMenu;
    private static Menu servicesMenu;

    public MainMenu() {
	clientsMenu = (Menu) new ClientsMenu();
	activitiesMenu = (Menu) new ActivitiesMenu();
	reportsMenu = (Menu) new ReportsMenu();
	servicesMenu = (Menu) new ServicesMenu();
    }

    public static final void show() {
	int selection = 0;
	boolean exit;
	exit = false;

	Scanner in = new Scanner(System.in);
	while (!exit) {
	    System.out.println("(1) To show clients\n"
		    + "(2) To show activities\n" + "(3) To show reports\n"
		    + "(4) To show services\n" + "(0) To exit\n" + "Choice: ");

	    try {
		selection = in.nextInt();
	    } catch (Exception e) {
		System.out.println("Input correct number!");
		selection = 0;
	    }

	    switch (selection) {

	    case 1:
		clientsMenu.showMenu();
		exit = true;
		break;

	    case 2:
		activitiesMenu.showMenu();
		exit = true;
		break;

	    case 3:
		reportsMenu.showMenu();
		exit = true;
		break;
	    case 4:
		servicesMenu.showMenu();
		exit = true;
		break;

	    case 0:
		System.out.println("Exiting...");
		exit = true;
		break;

	    default:
		System.out.println("Your choice was not valid!");
	    }
	}
	in.close();
    }

    @Override
    public void showMenu() {

    }
}
