package goit.nz.kickstarter.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
	private Scanner scanner;

	public Console() {
		scanner = new Scanner(System.in);
	}

	public void write(String output) {
		if (!output.isEmpty()) {
			System.out.println(output);
		}
	}

	public int readInt() {
		int result;
		while (true) {
			try {
				result = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				write("Input waits for ineteger number");
				scanner.nextLine();
			}
		}
		return result;
	}
}
