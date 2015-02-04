package ua.home.kickstarter;

import java.util.Scanner;

public class ConsoleInOut implements InOut {
	Scanner scanner = new Scanner(System.in);

	public int nextIntIndex() {
		return scanner.nextInt();
	}

	public void output(String s) {
		System.out.println(s);
	}
}
