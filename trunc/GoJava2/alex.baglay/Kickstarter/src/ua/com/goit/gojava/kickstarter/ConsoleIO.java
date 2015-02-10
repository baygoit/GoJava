package ua.com.goit.gojava.kickstarter;

import java.util.Scanner;

public class ConsoleIO implements IO {
	@Override
	public String read() {
		Scanner scanner = new Scanner(System.in);
		return scanner.next(); 
	}

	@Override
	public void print(String message) {
		System.out.print(message);
	}
}
