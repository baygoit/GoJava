package ua.com.goit.gojava7.kickstarter.console;

import java.util.Scanner;

public class ConsoleScanner{
	private Scanner scanner = new Scanner(System.in);

	public int getInt() {
		while (!scanner.hasNextInt()) {
			scanner.next();
		}
		int inputedInt = scanner.nextInt();
		return inputedInt;
	}

	public String getString() {
		while (!scanner.hasNextLine()) {
			scanner.next();
		}
		String inputString = scanner.nextLine();
		return inputString;
	}

	public void close() {
		scanner.close();
	}
}
