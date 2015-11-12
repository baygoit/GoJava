package ua.com.goit.gojava7.kickstarter.console;

import java.util.Scanner;

public class ConsoleInspector {
	private Scanner sc = new Scanner(System.in);

	public int getCorrectInt(int limitation) {
		int number = -1;		
		do {
			while (!sc.hasNextInt()) {
				sc.next();
			}
			number = sc.nextInt();
			if (number > limitation | number < 0) {
				System.out.println("You should type a number from 0 to " + limitation + ": ");
				number = -1;
			}
		} while (number == -1);
		return number;
	}

	public void close() {
		sc.close();
	}
}
