package ua.com.goit.gojava7.kickstarter.console;

import java.util.Scanner;

public class ConsoleInspector {
	private Scanner sc = new Scanner(System.in);

	public int getCorrectInt(int limitation) {
		int a = -1;		
		do {
			while (!sc.hasNextInt()) {
				sc.next();
			}
			a = sc.nextInt();
			if (a > limitation | a < 0) {
				System.out.println("You should type a number from 0 to " + limitation + ": ");
				a = -1;
			}
		} while (a == -1);
		return a;
	}

	public void close() {
		sc.close();
	}
}
