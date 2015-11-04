package ua.com.goit.gojava7.mergesort;

import java.util.Arrays;

public class App {

	private static final String DELIMITER = " ";
	private static final String WELCOME_MESSAGE = "Input array values divided by '" + DELIMITER + "' symbol";
	private static final String ERROR_MESSAGE = "Illegal argument. " + WELCOME_MESSAGE;
	
	public static void main(String[] args) {

		start();

	}
	
	public static void start() {

		Console console = new Console();
		console.print(WELCOME_MESSAGE);
		int[] numbers = null;
		
		while (numbers == null) {
			try {
				//numbers = console.parseIntArray("2 0 3 6 8 7 1 9 4 5", DELIMITER);
				numbers = console.readIntArray(DELIMITER);
			} catch (IllegalArgumentException e) {
				console.print(ERROR_MESSAGE);
			}
		}
		
		SortMerge.sort(numbers);
		console.print(Arrays.toString(numbers));

	}
	
}
