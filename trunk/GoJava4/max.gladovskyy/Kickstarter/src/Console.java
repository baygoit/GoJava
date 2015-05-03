import java.util.InputMismatchException;
import java.util.Scanner;


public class Console {
	public static final boolean NO_EXIT = false;
	public static final boolean EXIT = true;
	
	public static void clearScreen() {
	    for (int i = 0; i < 100; i++) {
	        System.out.println();
	    }
	}

	public static int getUserChois(int size, boolean exit) {
		System.out.println();
		System.out.print("Please make your chois end press enter: ");
		int userChois;
		while (true) {
			userChois = readChoise();
			if ((!exit && userChois == 0) || userChois < 0 || userChois > size) {
				System.err.println("There are no such variant. Make a choise and press enter");
			} else return userChois;
		}
	}

	private static int readChoise() {
		try {
			Scanner reader = new Scanner(System.in);
			return reader.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("You entered unacceptable character. Make a choise and press enter");
			return readChoise();
		}
	}
}
