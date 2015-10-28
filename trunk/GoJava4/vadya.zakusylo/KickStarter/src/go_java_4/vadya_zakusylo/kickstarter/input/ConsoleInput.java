package go_java_4.vadya_zakusylo.kickstarter.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput implements Input {
	public int read() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int index;
		try {
			index = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Incorrect input! Try input correct number!");
			System.out
					.println("--------------------------------------------------------------------------------");
			index = read();
		}
		return index;
	}
}
