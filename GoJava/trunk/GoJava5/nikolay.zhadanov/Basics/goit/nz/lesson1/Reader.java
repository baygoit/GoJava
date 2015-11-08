package goit.nz.lesson1;

import java.util.Scanner;

public class Reader {
	private final String AGREE_CODE = "y";
	private Scanner console;
	private String prompt;

	public Reader() {
		console = new Scanner(System.in);
		prompt = "";
	}

	public Reader(String prompt) {
		console = new Scanner(System.in);
		this.prompt = prompt;
	}

	public String readLine() {
		if (!prompt.isEmpty()) {
			System.out.println(prompt);
		}
		return console.nextLine();
	}

	public boolean askForRepeat() {
		System.out
				.printf("Do you want to repeat input? \"%s\" for yes, any other for exit",
						AGREE_CODE);
		return console.nextLine().toLowerCase().equals(AGREE_CODE);
	}
}
