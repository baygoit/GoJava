package kickstarter.reader;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader implements Reader {

	public int readUserInput() {
		int result = 0;
		try {
			result = new Scanner(System.in).nextInt();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		System.out.println();
		return result;
	}
}
