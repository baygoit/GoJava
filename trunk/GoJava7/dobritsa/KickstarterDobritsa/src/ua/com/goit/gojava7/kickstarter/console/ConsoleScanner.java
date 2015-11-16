package ua.com.goit.gojava7.kickstarter.console;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleScanner {
	private Scanner sc = new Scanner(System.in);
	
	public ConsoleScanner() {
		sc = new Scanner(System.in);
	}
	
	public ConsoleScanner(InputStream inputStream) {
		sc = new Scanner(inputStream);
	}

	public int getInteger(int start, int end) {
		while (true) {
			while (!sc.hasNextInt()) {
				System.out.println("You should type a NUMBER from " + start + " to " + end + ": ");
				sc.next();
			}
			int number = sc.nextInt();
			if ((number < start | number > end) & number != 0) {
				if (end == 0)
					System.out.println("Type " + end + " to choose another project:");
				else
					System.out.println("You should type a number FROM " + start + " TO " + end + ": ");
				continue;
			} else  {
				return number;
			}
		} 
	}

	public String getBackOrZero() {
		String text;
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
