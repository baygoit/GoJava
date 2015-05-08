package kickstarter;

import java.util.Scanner;

public class ConsoleUI implements UserInterface {
	Scanner scanner;
	ConsoleUI() {
		scanner = new Scanner(System.in);
	}

	@Override
	public String inputString() {
		String fromConsole = scanner.nextLine();
		return fromConsole;
	}

	@Override
	public void display(String stringToDisplay) {
		System.out.println(stringToDisplay);
	}
}
