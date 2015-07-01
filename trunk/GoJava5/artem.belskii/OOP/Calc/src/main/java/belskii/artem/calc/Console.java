package belskii.artem.calc;

import java.util.Scanner;

public class Console {

	public void write(String message) {
		System.out.println(message);
	}

	public String read() {
		Scanner consoleIn = new Scanner(System.in);
		System.out.println("Put expression in format x +(or -) y:");
		String input = consoleIn.nextLine();
		return input.toUpperCase();

	}
}
