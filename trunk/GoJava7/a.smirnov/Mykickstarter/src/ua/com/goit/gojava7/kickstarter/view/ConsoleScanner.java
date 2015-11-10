package ua.com.goit.gojava7.kickstarter.view;

import java.util.Scanner;

public class ConsoleScanner {

	private Scanner scanner = new Scanner(System.in);

	public int getInt() {
		while (!scanner.hasNextInt()) {
			scanner.next();
		}
		int inputedInt = scanner.nextInt();
		return inputedInt;
	}
	
	public String getString() {
		while (!scanner.hasNextInt()) {
			scanner.next();
		}
		String inputedString = scanner.nextLine();
		return inputedString;
	}

	public void close() {
		scanner.close();
	}

}
