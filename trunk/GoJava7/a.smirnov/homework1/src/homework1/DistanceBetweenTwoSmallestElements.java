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

	// Method searching all smallest and second smallest numbers in storage user's input numbers
	public void findDistancesBetweenSmallestElements(int[] storageOfUserInputNumbers) {

		// Storage for all smallest and second smallest numbers and their positions
		Map<Integer, Integer> storageOfSmallestElements = new HashMap<>();
		Map<Integer, Integer> storageOfSecondSmallestElements = new HashMap<>();

		int smallestElement = storageOfUserInputNumbers[0];
		int secondSmallestElement = Integer.MAX_VALUE;

		// Searching of smallest number in storage of user's input numbers
		for (int barrier = 0; barrier < storageOfUserInputNumbers.length; barrier++) {
			if (smallestElement > storageOfUserInputNumbers[barrier]) {
				smallestElement = storageOfUserInputNumbers[barrier];
			}
		}

		// Putting all smallest numbers and their positions in storage of smallest numbers
		for (int barrier = 0; barrier < storageOfUserInputNumbers.length; barrier++) {
			if (smallestElement == storageOfUserInputNumbers[barrier]) {
				storageOfSmallestElements.put(barrier, smallestElement);
			}
		}

		// Searching the second smallest numbers in storage of user's input numbers
		for (int barrier = 0; barrier < storageOfUserInputNumbers.length; barrier++) {
			if (secondSmallestElement > storageOfUserInputNumbers[barrier] && storageOfUserInputNumbers[barrier] > smallestElement) {
				secondSmallestElement = storageOfUserInputNumbers[barrier];
			}
		}

		// Putting all second smallest numbers and their positions in storage of second smallest numbers
		for (int barrier = 0; barrier < storageOfUserInputNumbers.length; barrier++) {
			if (secondSmallestElement == storageOfUserInputNumbers[barrier]) {
				storageOfSecondSmallestElements.put(barrier, secondSmallestElement);
			}
		}

		// Checking of second smallest number
		if (secondSmallestElement == Integer.MAX_VALUE) {
			printUsersInputNumbers(storageOfUserInputNumbers);
			System.out.println("There is no second smallest number. All user's numbers are equals.");
		} else {
			printUsersInputNumbers(storageOfUserInputNumbers);
			printAllDistanceBetweenTwoSmallestElements(storageOfUserInputNumbers, storageOfSmallestElements,
					storageOfSecondSmallestElements);
		}
	}

	// Method prints into console distances between smallest and second smallest numbers
	public void printAllDistanceBetweenTwoSmallestElements(int[] userInputNumbers,
			Map<Integer, Integer> storageOfSmallestElements, Map<Integer, Integer> storageOfSecondSmallestElements) {

		for (Map.Entry<Integer, Integer> firstEntry : storageOfSmallestElements.entrySet()) {
			for (Map.Entry<Integer, Integer> secondEntry : storageOfSecondSmallestElements.entrySet()) {
				System.out.println("Distance between numbers [" + firstEntry.getValue() + "] and ["
						+ secondEntry.getValue() + "] is: " + (Math.abs(firstEntry.getKey() - secondEntry.getKey())));
			}
		}
	}

	// Method allows user to set up data
	public static int[] setUpUserInputData() {
		String greetings = "integer numbers (not less than 2 numbers and not more than 20 numbers) "
				+ "separated by spaces: ";
		
		// Printing into console greeting text with instruction
		System.out.println("Please insert " + greetings);

		// Handling of user's input data
		while (true) {
			try {
				Scanner in = new Scanner(System.in);
				String tempText = in.nextLine();
				String[] inputUserText = tempText.split(" ");
				int[] storageOfUsersInputNumbers = new int[inputUserText.length];

				// Parsing every user's input numbers and adding to storage of user's input numbers
				for (int barrier = 0; barrier < inputUserText.length; barrier++) {
					storageOfUsersInputNumbers[barrier] = Integer.parseInt(inputUserText[barrier]);
				}

				// Checking amount of user's input numbers
				if (storageOfUsersInputNumbers.length < 2 || storageOfUsersInputNumbers.length > 20) {
					throw new Exception();
				} else {
					return storageOfUsersInputNumbers;
				}
			} catch (Exception e) {
				System.out.println("User inserted wrong value." + System.lineSeparator() + "Please, insert one more time "
						+ greetings);
			}
		}
	}

	// Method prints into console user's input numbers
	public void printUsersInputNumbers(int[] userInputNumbers) {
		System.out.println("User inserted numbers " + Arrays.toString(userInputNumbers));
	}
}
