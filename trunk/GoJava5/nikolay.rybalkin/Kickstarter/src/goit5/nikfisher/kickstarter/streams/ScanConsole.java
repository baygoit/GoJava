package goit5.nikfisher.kickstarter.streams;

import java.util.Scanner;


public class ScanConsole implements Read {

	public int consoleScan(){

		Scanner scaner = new Scanner(System.in);
		int number = 0;
		try {
			scaner.hasNextInt();
			number = scaner.nextInt();
		} catch (Exception e) {
			System.out.println("You entered is not a number!");
		}
		return number;
	}
}
