package homework1;

import java.util.*;

/**
 * LonelyNumber.java
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

	// Method finds lonely number in user's input array of numbers
	public void findLonelyNumber(int[] userInputNumbers) {

		// Storage for lonely numbers
		List<Integer> storageOfLonelyNumbers = new ArrayList<>();

		// Storage for all unique numbers from user's input array of numbers
		Set<Integer> storageOfUniqueElements = new HashSet<>();

		// Adding all unique numbers from user's input array of numbers to storage
		for (int barrier = 0; barrier < userInputNumbers.length; barrier++) {
			storageOfUniqueElements.add(userInputNumbers[barrier]);
		}

		for (int unigueNumber : storageOfUniqueElements) {

			// Amount of duplicates
			int amountOfDuplicates = 0;

			// Comparing every element from storage of unique numbers with all user's input numbers
			for (int index = 0; index < userInputNumbers.length; index++) {
				if (unigueNumber == userInputNumbers[index]) {
					amountOfDuplicates++;
				}
			}

			// Checking for lonely number
			if (amountOfDuplicates == 3) {
				storageOfLonelyNumbers.add(unigueNumber);
			}

		}

		printIntoConsoleResult(userInputNumbers, storageOfLonelyNumbers);
	}

	// Method prints into console result of lonely number searching
	public static void printIntoConsoleResult(int[] userInputNumbers, List<Integer> listOfLonelyNumbers) {
		
		printUsersInputNumbers(userInputNumbers);

		// Checking of lonely numbers storage
		if (listOfLonelyNumbers.size() == 0) {
			System.out.println("There is no lonely number in user's input numbers");
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

		// Printing into console greeting text with instruction
		System.out.println("Please insert " + greetings);

		// Handling of user's input data
		while (true) {
			try {
				Scanner in = new Scanner(System.in);
				String tempText = in.nextLine();
				String[] inputUsersText = tempText.split(" ");
				int[] storageOfUsersInputNumbers = new int[inputUsersText.length];

				// Parsing every user's input numbers and adding to storage of user's input numbers
				for (int barrier = 0; barrier < inputUsersText.length; barrier++) {
					storageOfUsersInputNumbers[barrier] = Integer.parseInt(inputUsersText[barrier]);
				}

				// Checking amount of user's input numbers
				if (storageOfUsersInputNumbers.length < 3 || storageOfUsersInputNumbers.length > 20) {
					throw new Exception();
				} else {
					return storageOfUsersInputNumbers;
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
