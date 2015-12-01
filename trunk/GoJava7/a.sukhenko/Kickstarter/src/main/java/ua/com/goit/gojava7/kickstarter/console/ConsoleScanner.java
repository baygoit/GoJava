package ua.com.goit.gojava7.kickstarter.console;

import java.util.Scanner;

public class ConsoleScanner {
	private static Scanner scanner = new Scanner(System.in);

	public static int getInt() {
		while (!scanner.hasNextInt()) {
			scanner.next();
		}
		int inputedInt = scanner.nextInt();
		scanner.nextLine();
		return inputedInt;
	}

	public static String getString() {
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
