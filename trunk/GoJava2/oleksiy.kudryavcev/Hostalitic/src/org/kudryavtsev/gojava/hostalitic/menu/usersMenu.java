package org.kudryavtsev.gojava.hostalitic.menu;

import java.util.Scanner;

import org.kudryavtsev.gojava.hostalitic.Client;
import org.kudryavtsev.gojava.hostalitic.Hostalitic;

public class usersMenu extends Menu {

    public final void showMenu() {
	int selection = 0;
	boolean exit;
	exit = false;

	Scanner in = new Scanner(System.in);

	for (Client item : Hostalitic.clients) {
	    String element = item.toString();
	    System.out.println(element);
	}

	while (!exit) {

	    System.out.println("(1) Modify user\n" + "(2) Add user\n"
		    + "(3) Delete user\n" + "(0) Go to previous menu\n"
		    + "Choice: ");
	    try {
		selection = in.nextInt();
	    } catch (Exception e) {
		System.out.println("Input correct number!");
		selection = 0;
	    }

	    switch (selection) {

	    case 1:
		System.out.println("modify not implemented yet");
		break;

	    case 2:
		System.out.println("add not implemented yet");
		break;

	    case 3:
		System.out.println("delete not implemented yet");
		break;

	    case 0:
		mainMenu.show();
		exit = true;
		break;

	    default:
		System.out.println("Your choice was not valid!");
	    }
	}
	in.close();
    }
}
