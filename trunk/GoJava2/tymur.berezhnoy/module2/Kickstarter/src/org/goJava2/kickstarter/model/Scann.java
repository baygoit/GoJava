package org.goJava2.kickstarter.model;
import java.util.Scanner;

public class Scann {
	
	public int choise() {
		 boolean inputRight = false;
         int choise = 0;
         do {
        	 try {
        		 choise = Integer.valueOf(new Scanner(System.in).nextLine());
        		 inputRight = true;
        	 } catch (NumberFormatException Integer) {
        		 System.out.println("Wrong input. Only digits!");
        		 inputRight = false;
        	 }
         } while (!inputRight);
         return choise;
	}
}