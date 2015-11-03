package com.sin.eugene;


import java.util.Scanner;

public class Console {

	private String userInput;
	private Scanner inputReader;

	private static final String WELCOME_MESSAGE = "Input array values divided by spaces";
	private static final String DELIMITER = " ";

	public Console() {
		// OLEG do we need this emply line? This is our code convention? But in setUserInput() there is no empty line... Inconsistent

		this.userInput = "";
		this.inputReader = new Scanner(System.in);

	}

	// OLEG it looks line this method do something more then just set...
	public void setUserInput(String userInput) {
		System.out.println(WELCOME_MESSAGE);
		this.userInput = userInput;
		System.out.println(this.userInput);
	}

	public void readUserInput() {

		System.out.println(WELCOME_MESSAGE);
		this.userInput = this.inputReader.nextLine();

	}

	public int[] parseUserInput() {

		String[] numbers = this.userInput.split(DELIMITER);
		// OLEG reSult!
		int[] rezult = new int[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			// OLEG what about runtime exception? just exit application with default stacktrace?
			rezult[i] = Integer.parseInt(numbers[i]);
		}

		return rezult;

	}

	public void close() {

		this.inputReader.close();
		// OLEG why? It clear now that Console is not just a class to work with STDIN/STDOUT, but hold some string and threat it as array of integer delimited by DELIMITER, and parse string to array of integers
		// OLEG SRL?
		this.userInput = "";

	}

}
