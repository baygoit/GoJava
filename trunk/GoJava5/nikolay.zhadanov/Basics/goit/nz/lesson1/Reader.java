package goit.nz.lesson1;

import java.util.Scanner;

public class Reader {
	private final String AGREE_CODE = "y";
	private Scanner console;
	private String prompt;

	public Reader() {
		this.console = new Scanner(System.in);
		this.prompt = "";
	}

	public Reader(String prompt) {
		this.console = new Scanner(System.in);
		this.prompt = prompt;
	}

	public String readLine() {
		if (!this.prompt.isEmpty()) {
			System.out.println(prompt);
		}
		return this.console.nextLine();
	}

	public boolean askForRepeat() {
		System.out.println("Do you want to repeat input? \""
				+ this.AGREE_CODE + "\" for yes, any other for exit");
		return console.nextLine().toLowerCase().equals(this.AGREE_CODE);
	}
}
