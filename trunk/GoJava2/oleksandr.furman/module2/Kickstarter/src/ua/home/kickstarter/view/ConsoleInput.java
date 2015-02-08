package ua.home.kickstarter.view;

import java.util.Scanner;

public class ConsoleInput {
	Scanner scanner = new Scanner(System.in);

	public int nextIntIndex() {
		return scanner.nextInt();
	}
}
