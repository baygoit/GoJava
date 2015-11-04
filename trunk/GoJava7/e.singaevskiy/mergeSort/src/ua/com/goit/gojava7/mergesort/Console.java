package ua.com.goit.gojava7.mergesort;

import java.util.Scanner;

public class Console {

	private Scanner inputReader;
	
	private Scanner getInputReader(){
		if (inputReader == null) {
			inputReader = new Scanner(System.in);			
		}
		return inputReader;
	}
	
	private String readLine(){
		if (getInputReader().hasNextLine()) {
			return getInputReader().nextLine();
		} else {
			return "";
		}
	}

	public int[] readIntArray(String delimiter) throws IllegalArgumentException {

		return parseIntArray(readLine(), delimiter);

	}

	public int[] parseIntArray(String numbersInLine, String delimiter) throws IllegalArgumentException {
		String[] numbers = numbersInLine.split(delimiter);
		int[] result = new int[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			result[i] = Integer.parseInt(numbers[i]);
		}
		return result;
	}

	public void print(String message){
		System.out.println(message);
	}

}
