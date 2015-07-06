package goit.nz.kickstarter;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
	private Scanner scanner;

	public Console(InputStream in) {
		scanner = new Scanner(in);
	}

	public void write(String output) {
		System.out.println(output);
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
