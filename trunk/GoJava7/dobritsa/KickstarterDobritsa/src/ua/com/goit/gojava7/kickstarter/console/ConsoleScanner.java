package ua.com.goit.gojava7.kickstarter.console;

import java.util.Scanner;

public class ConsoleScanner {
	private Scanner sc = new Scanner(System.in);

	public Integer getInteger(int start, int end) {
		Integer number = -1;
		do {
			while (!sc.hasNextInt()) {
				sc.next();
			}
			number = sc.nextInt();
			if (number > end | number < 0) {
				if (end == 0)
					System.out.println("Type " + end + " to choose another project:");
				else
					System.out.println("You should type a number from " + start + " to " + end + ": ");
				number = -1;
			} else if (number == 0) {
				return null;
			}
		} while (number == -1);
		return number;
	}

	public String getBackOrZero() {
		String text = "-1";
		while (true) {
			System.out.println("\nType:" + "\nb: to back this project" + "\n0: to choose another project");
			text = sc.next();
			if (text.equals("0"))
				return "0";
			else if (text.equals("b"))
				return "b";
		}
	}
	
	public String getName() {
		//TODO check
		String text = sc.next();
		return text;
	}
	
	public String getCreditCard() {
		//TODO check
		String text = sc.next();
		return text;
	}

	public String getString() {
		String text = sc.next();
		return text;
	}

	public void close() {
		sc.close();
	}
}
