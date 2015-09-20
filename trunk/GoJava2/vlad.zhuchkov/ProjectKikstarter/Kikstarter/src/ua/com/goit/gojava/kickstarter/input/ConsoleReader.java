package ua.com.goit.gojava.kickstarter.input;

import java.util.Scanner;

public class ConsoleReader implements Input {

	public String read() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

}
