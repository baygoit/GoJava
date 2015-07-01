package goit.nz.lesson1.calculator;

import java.util.Scanner;

public class Console {
	public static final String AGREE_CODE = "y";
	private Scanner scanner;

	public Console() {
		this.scanner = new Scanner(System.in);
	}

	public String read(String prompt) {
		System.out.println(prompt);
		String result = this.scanner.nextLine();
		return result;
	}

	public void write(String message) {
		System.out.println(message);
	}
}
