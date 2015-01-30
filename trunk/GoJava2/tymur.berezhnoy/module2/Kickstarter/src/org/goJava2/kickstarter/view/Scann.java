package org.goJava2.kickstarter.view;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Scann {
	
	public int choice() {
		 boolean inputRight = false;
         int choice = 0;
         do {
        	 try {
        		 choice = new Scanner(System.in).nextInt();
        		 inputRight = true;
        	 } catch (InputMismatchException e) {
        		 System.out.print("- Only numbers! Try again\n> ");
        		 inputRight = false;
        	 }
         } while (!inputRight);
         return choice;
	}
}