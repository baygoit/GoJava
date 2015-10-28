package ua.com.goit.belskii.artem;

import java.util.Scanner;

public class Input {
	Scanner consoleIn = new Scanner(System.in);
	private String input = "";

	public void setString() {
		System.out.println("Please, enter expression in format x/y");
		input = consoleIn.nextLine();
	}

	public String[] getInput() {
		String[] separateNumbers = input.split("/");
		String[] answer = new String[separateNumbers.length];
		for (int i = 0; i < separateNumbers.length; i++) {
			answer[i] = separateNumbers[i];
		}

		return answer;
	}
}
