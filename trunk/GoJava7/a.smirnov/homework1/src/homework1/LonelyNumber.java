package homework1;

import java.util.*;

/**
 * LonelyNumber.java
 * 
 * @author Anton Smirnov
 * @version 22.10.2015
 * @java 7
 * @category homework1
 *
 */

public class LonelyNumber {
	public static void main(String[] args) {

		// Testing
		new LonelyNumber().printIntoConsoleResult(findLonelyNumber(setUpUserInputData()));
	}

	/* Method finds lonely number in input array */
	public static List<Integer> findLonelyNumber(int[] array) {

		// List for saving all values which meet three times in input array
		List<Integer> listOfLonelyNumbers = new ArrayList<>();

		// Set for all unique elements from input array
		Set<Integer> setOfUniqueElements = new HashSet<>();

		// Add to list all unique elements from input array
		for (int barrier = 0; barrier < array.length; barrier++) {
			setOfUniqueElements.add(array[barrier]);
		}

		// Checking the input array's capacity
		if (array.length < 3) {
			System.out.println("Incorrect amount of elements in array.");
		} else {

			for (int value : setOfUniqueElements) {

				// Counter for calculating quantity of each HashSet element
				// duplicates
				int countOfSteps = 0;

				// Comparison of elements from HashSet with elements from input
				// array
				for (int index = 0; index < array.length; index++) {
					if (value == array[index]) {
						countOfSteps++;
					}
				}

				// Checking for lonely number
				if (countOfSteps == 3) {
					listOfLonelyNumbers.add(value);
				}

				// Checking on exceptions
				if (countOfSteps > 3) {
					System.out.println("Incorrect elements in array. Element [" + value
							+ "] has been met in array more than three times.");
					System.exit(0);
				}
			}
		}
		return listOfLonelyNumbers;
	}

	/*
	 * Method prints into console result of lonely number searching process in
	 * the input array
	 */
	public void printIntoConsoleResult(List<Integer> listOfLonelyNumbers) {
		
		// Checking the list of lonely numbers
		if (listOfLonelyNumbers.isEmpty()) {
			System.out.println("There is no lonely number in array");
		} else if (listOfLonelyNumbers.size() == 1) {
			System.out.println("Lonely number: " + listOfLonelyNumbers);
		} else {
			System.out.println("Incorrect elements in array. There are more than one lonely number in array: "
					+ listOfLonelyNumbers);
		}
	}

	// Method allowing user set up input data for program
	public static int[] setUpUserInputData() {
		System.out.println("Please insert integer numbers for array separated by spaces: ");

		// Handling of user's input data
		while (true) {
			try {
				Scanner input = new Scanner(System.in);
				String inputUserString = input.nextLine();
				String[] arrayOfUsersNumbers = inputUserString.split(" ");
				int[] inputUsersNumbers = new int[arrayOfUsersNumbers.length];

				// Parsing every value from string array and adding to integer
				// array
				for (int barrier = 0; barrier < arrayOfUsersNumbers.length; barrier++) {
					inputUsersNumbers[barrier] = Integer.parseInt(arrayOfUsersNumbers[barrier]);
				}

				if (inputUsersNumbers.length < 3) {
					throw new Exception();
				} else {
					
					// Printing into console the user's input array
					System.out.println("User insert array " + Arrays.toString(inputUsersNumbers));
					return inputUsersNumbers;
				}
			} catch (Exception e) {
				System.out.println("User insert wrong value."
						+ " Please, insert one more time integer numbers for array separated by spaces :  ");
			}
		}
	}
}
