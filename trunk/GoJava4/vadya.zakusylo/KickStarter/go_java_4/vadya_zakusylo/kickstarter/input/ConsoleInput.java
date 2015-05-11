package go_java_4.vadya_zakusylo.kickstarter.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput implements Input {

	private boolean isNumber = true;
	private int index;

	public int read() {
		/*while (isNumber) {
			try {
				index = new Scanner(System.in).nextInt();
				isNumber = false;
			} catch (InputMismatchException e) {
				System.out.println("Incorrect input! Try input correct number!");
			}
		}*/
		return index = new Scanner(System.in).nextInt();
	}
}
