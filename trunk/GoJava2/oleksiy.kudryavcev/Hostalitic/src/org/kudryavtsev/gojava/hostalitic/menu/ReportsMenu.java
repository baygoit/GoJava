package org.kudryavtsev.gojava.hostalitic.menu;

import java.util.Scanner;

public class ReportsMenu extends Menu {
    public final void showMenu() {
	int selection = 0;
	boolean exit;
	exit = false;

	Scanner in = new Scanner(System.in);

	while (!exit) {

	    System.out.println("(1) Report 1\n" + "(2) Report 2\n"
		    + "(3) Report 3\n" + "(0) Go to previous menu\n"
		    + "Choice: ");
	    try {
		selection = in.nextInt();
	    } catch (Exception e) {
		System.out.println("Input correct number!");
		selection = 0;
	    }

	    switch (selection) {

	    case 1:
		System.out.println("report 1 not implemented yet");
		break;

	    case 2:
		System.out.println("report 2 not implemented yet");
		break;

	    case 3:
		System.out.println("report 3 not implemented yet");
		break;

	    case 0:
		MainMenu.show();
		exit = true;
		break;

	    default:
		System.out.println("Your choice was not valid!");
	    }
	}
	in.close();
    }
}
