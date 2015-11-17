package ua.com.goit.gojava7.kickstarter.console;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleScanner {

	private Scanner scanner;

	public ConsoleScanner() {
		scanner = new Scanner(System.in);
	}

	public ConsoleScanner(InputStream inputStream) {
		scanner = new Scanner(inputStream);
	}

	public int scan() {

		while (!scanner.hasNextInt()) {
			scanner.next();
		}
		int inputedInt = scanner.nextInt();
		scanner.nextLine();
		return inputedInt;
	}

	public void close() {
		scanner.close();
	}

	public String scanLine() {

/*		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}*/
		return scanner.nextLine();
	}

}
