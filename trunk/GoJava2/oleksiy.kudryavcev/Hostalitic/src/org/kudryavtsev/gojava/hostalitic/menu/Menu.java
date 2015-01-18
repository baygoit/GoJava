package org.kudryavtsev.gojava.hostalitic.menu;

import java.util.Scanner;

public class Menu {
    public void showMenu() {
	Scanner in = new Scanner(System.in);
	do {
	    System.out.println("(1) To show users\n"
		    + "(2) To show activities\n" 
		    + "(3) To show peports\n"
		    + "(0) To exit");
	} while (!(in.nextInt() == 0));
	in.close();
    }
}

