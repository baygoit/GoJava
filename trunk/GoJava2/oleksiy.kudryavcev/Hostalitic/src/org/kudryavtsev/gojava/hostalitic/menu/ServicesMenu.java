package org.kudryavtsev.gojava.hostalitic.menu;

import java.util.Scanner;

import org.kudryavtsev.gojava.hostalitic.Fabric;
import org.kudryavtsev.gojava.hostalitic.Hostalitic;
import org.kudryavtsev.gojava.hostalitic.Service;

public class ServicesMenu extends Menu {
    public final void showMenu() {
	int selection = 0;
	boolean exit;
	exit = false;

	Scanner in = new Scanner(System.in);
	
	for (Service item : Hostalitic.services) {
	    String element = item.toString();
	    System.out.println(element);
	}
	
	while (!exit) {

	    System.out.println("(1) Modify service\n" + "(2) Add service\n"
		    + "(3) Delete service\n" + "(0) Go to previous menu\n"
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
		System.out.println("add not implemented");
//		System.out.print("Enter activity name: ");
//		Fabric.createActivity((new Scanner(System.in)).nextLine());
		break;

	    case 3:
		System.out.println("delete not implemented yet");
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
