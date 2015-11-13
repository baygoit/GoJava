package ua.com.goit.gojava7.kickstarter.console;

import java.util.Scanner;

public class ConsoleScanner {

	private Scanner scanner = new Scanner(System.in);

	public int scan() {

		while (!scanner.hasNextInt()) {
			scanner.next();
		}
		int inputedInt = scanner.nextInt();
		return inputedInt;
	}

	public void close() {
		scanner.close();
	}

}
