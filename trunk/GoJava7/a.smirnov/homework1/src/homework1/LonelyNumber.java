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
		new LonelyNumber().findLonelyNumber(setUpUserInputData());
	}

	/* Method finds lonely number in user's input array of numbers */
	public void findLonelyNumber(int[] userInputNumbers) {

		// List for saving lonely numbers
		List<Integer> listOfLonelyNumbers = new ArrayList<>();

		// Set for all unique elements from user's input array of numbers
		Set<Integer> setOfUniqueElements = new HashSet<>();

		// Adding to set of all unique numbers from user's input array of
		// numbers
		for (int barrier = 0; barrier < userInputNumbers.length; barrier++) {
			setOfUniqueElements.add(userInputNumbers[barrier]);
		}

		for (int userNumber : setOfUniqueElements) {

			// Counter for searching lonely numbers
			int countOfSteps = 0;

			// Comparing every set's number with user's input numbers
			for (int index = 0; index < userInputNumbers.length; index++) {
				if (userNumber == userInputNumbers[index]) {
					countOfSteps++;
				}
			}

			// Checking for lonely number
			if (countOfSteps == 3) {
				listOfLonelyNumbers.add(userNumber);
			}

		}

		// Printing into console result of searching
		printIntoConsoleResult(userInputNumbers, listOfLonelyNumbers);
	}

	// Method prints into console result of lonely number searching
	public static void printIntoConsoleResult(int[] userInputNumbers, List<Integer> listOfLonelyNumbers) {
		printUsersInputNumbers(userInputNumbers);

		// Checking the list of lonely numbers
		if (listOfLonelyNumbers.size() == 0) {
			System.out.println("There is no lonely number in array of user's input numbers");
		} else if (listOfLonelyNumbers.size() == 1) {
			System.out.println("Lonely number:" + listOfLonelyNumbers);
		} else {
			System.out.println(
					"There are more than one lonely numbers in array of user's input numbers: " + listOfLonelyNumbers);
		}
	}

	// Method allows user to set up data
	public static int[] setUpUserInputData() {
		String greetings = "integer numbers (not less than 3 numbers) separated by spaces: ";

		// Printing into console greeting string with instruction
		System.out.println("Please insert " + greetings);

		// Handling of user's input data
		while (true) {
			try {
				Scanner in = new Scanner(System.in);
				String inputUserString = in.nextLine();
				String[] arrayOfUsersNumbers = inputUserString.split(" ");
				int[] inputUsersNumbers = new int[arrayOfUsersNumbers.length];

				// Parsing every user's input numbers and adding to integer
				// array
				for (int barrier = 0; barrier < arrayOfUsersNumbers.length; barrier++) {
					inputUsersNumbers[barrier] = Integer.parseInt(arrayOfUsersNumbers[barrier]);
				}

				// Checking integer array's capacity of user's input numbers
				if (inputUsersNumbers.length < 3) {
					throw new Exception();
				} else {
					return inputUsersNumbers;
				}
			} catch (Exception e) {
				System.out.println("User inserted wrong value." + System.lineSeparator()
						+ "Please, insert one more time " + greetings);
			}
		}
	}

	// Method prints into console user's input numbers
	public static void printUsersInputNumbers(int[] userInputNumbers) {
		System.out.println("User inserted numbers " + Arrays.toString(userInputNumbers));
	}
}
