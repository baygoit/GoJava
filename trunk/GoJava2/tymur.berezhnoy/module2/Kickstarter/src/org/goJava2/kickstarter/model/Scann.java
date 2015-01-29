package org.goJava2.kickstarter.model;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Scann {
	
	public int choise() {
		 boolean inputRight = false;
         int choise = 0;
         do {
        	 try {
        		 choise = new Scanner(System.in).nextInt();
        		 inputRight = true;
        	 } catch (InputMismatchException e) {
        		 System.out.print("- Only numbers! Try again\n> ");
        		 inputRight = false;
        	 }
         } while (!inputRight);
         return choise;
	}
}