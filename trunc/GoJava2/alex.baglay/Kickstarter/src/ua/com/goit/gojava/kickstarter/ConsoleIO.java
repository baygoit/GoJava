package ua.com.goit.gojava.kickstarter;

import java.util.Scanner;

public class ConsoleIO implements IO {
	@Override
	public int read() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	@Override
	public void print(String message) {
		System.out.print(message);
	}
}
