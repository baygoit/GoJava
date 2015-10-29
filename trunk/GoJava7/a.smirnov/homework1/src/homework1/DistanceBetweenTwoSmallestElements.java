package homework1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * DistanceBetweenTwoSmallestElements.java
 * @author Anton Smirnov
 * @version 22.10.2015
 * @java 7
 * @category homework1
 *
 */

public class DistanceBetweenTwoSmallestElements {
	public static void main(String[] args) {

		// Testing
		new DistanceBetweenTwoSmallestElements().findDistancesBetweenSmallestElements(setUpUserInputData());
	}

	// Method searching all smallest and second smallest numbers in array of user's input numbers
	public void findDistancesBetweenSmallestElements(int[] userInputNumbers) {

		// Maps for saving all smallest and second smallest numbers and their positions
		Map<Integer, Integer> mapOfSmallestElements = new HashMap<>();
		Map<Integer, Integer> mapOfSecondSmallestElements = new HashMap<>();

		int smallestElement = userInputNumbers[0];
		int secondSmallestElement = Integer.MAX_VALUE;

		// Searching the smallest number in array of user's input numbers
		for (int barrier = 0; barrier < userInputNumbers.length; barrier++) {
			if (smallestElement > userInputNumbers[barrier]) {
				smallestElement = userInputNumbers[barrier];
			}
		}

		// Putting all smallest numbers and their positions in map of smallest numbers
		for (int barrier = 0; barrier < userInputNumbers.length; barrier++) {
			if (smallestElement == userInputNumbers[barrier]) {
				mapOfSmallestElements.put(barrier, smallestElement);
			}
		}

		// Searching the second smallest numbers in array of user's input numbers
		for (int barrier = 0; barrier < userInputNumbers.length; barrier++) {
			if (secondSmallestElement > userInputNumbers[barrier] && userInputNumbers[barrier] > smallestElement) {
				secondSmallestElement = userInputNumbers[barrier];
			}
		}

		// Putting all second smallest numbers and their positions in map of second smallest numbers
		for (int barrier = 0; barrier < userInputNumbers.length; barrier++) {
			if (secondSmallestElement == userInputNumbers[barrier]) {
				mapOfSecondSmallestElements.put(barrier, secondSmallestElement);
			}
		}

		// Checking of second smallest number existing in array of user's input numbers
		if (secondSmallestElement == Integer.MAX_VALUE) {
			printUsersInputNumbers(userInputNumbers);
			System.out.println("There is no second smallest element in inserted numbers."
					+ " All inserted numbers are equals.");
		} else {
			printUsersInputNumbers(userInputNumbers);
			printAllDistanceBetweenTwoSmallestElements(userInputNumbers, mapOfSmallestElements,
					mapOfSecondSmallestElements);
		}
	}

	// Method prints into console distances between smallest numbers in array of user's input numbers
	public void printAllDistanceBetweenTwoSmallestElements(int[] userInputNumbers,
			Map<Integer, Integer> mapOfSmallestElements, Map<Integer, Integer> mapOfSecondSmallestElements) {

		for (Map.Entry<Integer, Integer> firstEntry : mapOfSmallestElements.entrySet()) {
			for (Map.Entry<Integer, Integer> secondEntry : mapOfSecondSmallestElements.entrySet()) {
				System.out.println("Distance between numbers [" + firstEntry.getValue() + "] and ["
						+ secondEntry.getValue() + "] is: " + (Math.abs(firstEntry.getKey() - secondEntry.getKey())));
			}
		}
	}

	// Method allows user to set up data
	public static int[] setUpUserInputData() {
		String greeting = "integer numbers (not less than 2 numbers and not more than 20 numbers) "
				+ "separated by spaces: ";
		
		// Printing into console greeting string with instruction
		System.out.println("Please insert " + greeting);

		// Handling of user's input data
		while (true) {
			try {
				Scanner input = new Scanner(System.in);
				String inputUserString = input.nextLine();
				String[] userInputNumbers = inputUserString.split(" ");
				int[] parsedUserInputNumbers = new int[userInputNumbers.length];

				// Parsing every user's input numbers and adding to integer array
				for (int barrier = 0; barrier < userInputNumbers.length; barrier++) {
					parsedUserInputNumbers[barrier] = Integer.parseInt(userInputNumbers[barrier]);
				}

				// Checking integer array's capacity of user's input numbers
				if (parsedUserInputNumbers.length == 0 || parsedUserInputNumbers.length == 1
						|| parsedUserInputNumbers.length > 20) {
					throw new Exception();
				} else {
					return parsedUserInputNumbers;
				}
			} catch (Exception e) {
				System.out.println("User insert wrong value." + System.lineSeparator() + "Please, insert one more time "
						+ greeting);
			}
		}
	}

	// Method prints into console user's input numbers
	public void printUsersInputNumbers(int[] userInputNumbers) {
		System.out.println("User inserted numbers " + Arrays.toString(userInputNumbers));
	}
}
