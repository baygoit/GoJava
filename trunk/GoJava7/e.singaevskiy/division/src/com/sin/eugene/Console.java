package com.sin.eugene;

import java.util.Scanner;

public class Console {

	private String userInput;
	private Scanner inputReader;

	private static final String WELCOME_MESSAGE = "Input two digits divided by '/'";
	private static final String DELIMITER = "/";

	public Console() {

		this.userInput = "";
		this.inputReader = new Scanner(System.in);

	}

	public void readUserInput() {

		System.out.println(WELCOME_MESSAGE);
		this.userInput = this.inputReader.nextLine();

	}

	public int[] parseUserInput() {

		String[] numbers = this.userInput.split(DELIMITER);
		int[] rezult = new int[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			rezult[i] = Integer.parseInt(numbers[i]);
		}

		return rezult;

	}

	public void close() {

		this.inputReader.close();
		this.userInput = "";

	}

}
