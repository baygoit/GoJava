package ua.com.goit.gojava7.kickstarter.console;

import java.util.Scanner;

public class ConsoleScanner {

	// TODO replace me with something else, I cannot be mocked even with powermock :(
	Scanner scanner = new Scanner(System.in);

	public int getInt() {
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
