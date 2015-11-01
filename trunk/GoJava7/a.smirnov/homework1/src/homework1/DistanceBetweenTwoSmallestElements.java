package homework1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * DistanceBetweenTwoSmallestElements.java
 * @author Anton Smirnov
 * @version 01.11.2015
 * @java 7
 * @category homework1
 * 
 */

public class DistanceBetweenTwoSmallestElements {
	public static void main(String[] args) {

		// Testing
		new DistanceBetweenTwoSmallestElements().startProgram();
	}

	public void startProgram() {	
		printUserInsertedNumbersAndDistanceBetweenTwoSmallestNumbers();
	}

	// Setup input data by User
	private static int[] setupUserNumbers() {
		String instruction = "Please insert integer numbers (not less than 2 numbers and not more than 20 numbers) "
				+ "separated by spaces: ";

		System.out.println(instruction);
		while (true) {
			try {
				Scanner in = new Scanner(System.in);
				String tempText = in.nextLine();
				String[] inputUserText = tempText.split(" ");
				int[] storageOfUsersNumbers = new int[inputUserText.length];

				for (int barrier = 0; barrier < inputUserText.length; barrier++) {
					storageOfUsersNumbers[barrier] = Integer.parseInt(inputUserText[barrier]);
				}

				if (storageOfUsersNumbers.length < 2 || storageOfUsersNumbers.length > 20) {
					throw new RuntimeException();
				} else {
					return storageOfUsersNumbers;
				}
			} catch (RuntimeException e) {
				System.out.println("User inserted wrong value. Please try again." + System.lineSeparator() + instruction);
			}
		}
	}
	
	// Finding distance between smallest and second smallest numbers in storage of user's inserted numbers
	private String findDistancesBetweenSmallestElements() {
		int[] storageOfUserNumbers = setupUserNumbers();

		Map<Integer, Integer> storageOfSmallestNumbers = new HashMap<>();
		Map<Integer, Integer> storageOfSecondSmallestNumbers = new HashMap<>();

		int smallestElement = searchSmallestNumber(storageOfUserNumbers);
		StringBuilder result = new StringBuilder();
		result.append("User's inserted numbers: " + Arrays.toString(storageOfUserNumbers) + System.lineSeparator());
		try {

			int secondSmallestElement = searchSecondSmallestNumber(storageOfUserNumbers);
			addNumbersAndTheirPositionInStorage(storageOfSmallestNumbers, storageOfUserNumbers, smallestElement);
			addNumbersAndTheirPositionInStorage(storageOfSecondSmallestNumbers, storageOfUserNumbers, secondSmallestElement);

			for (Map.Entry<Integer, Integer> firstEntry : storageOfSmallestNumbers.entrySet()) {
				for (Map.Entry<Integer, Integer> secondEntry : storageOfSecondSmallestNumbers.entrySet()) {
					result.append("Distance between numbers [").append(firstEntry.getValue()).append("] and [").
							append(secondEntry.getValue()).append("] is: ").append(Math.abs(firstEntry.getKey() - secondEntry.getKey())).
							append(System.lineSeparator());
				}
			}

		} catch (RuntimeException e) {
			result.append("There is no second smallest number. All user's numbers are equals.");
		}
		return result.toString();
	}

	
	// Printing into console distance between smallest and second smallest numbers
	private void printUserInsertedNumbersAndDistanceBetweenTwoSmallestNumbers() {
		String result = findDistancesBetweenSmallestElements();
		System.out.println(result);
	}

	
	// Searching second smallest number in storage of user's inserted numbers
	private int searchSmallestNumber(int[] storageOfNumbers) {
		Arrays.sort(storageOfNumbers);
		return storageOfNumbers[0];
	}

	
	// Searching smallest number in storage of user's inserted numbers
	private int searchSecondSmallestNumber(int[] storageOfNumbers) {
		int secondSmallestNumber = 0;
		for (int index = 0; index < storageOfNumbers.length; index++) {
			if (storageOfNumbers[index] > storageOfNumbers[0]) {
				secondSmallestNumber = storageOfNumbers[index];
				return secondSmallestNumber;
			}
		}
		throw new RuntimeException();
	}

	
	// Finding and putting all smallest or second smallest numbers and their positions in storage
	private void addNumbersAndTheirPositionInStorage(Map<Integer, Integer> storage, int[] numbers, int smallestNumber) {
		for (int index = 0; index < numbers.length; index++) {
			if (smallestNumber == numbers[index]) {
				storage.put(index, smallestNumber);
			}
		}
	}
}
