package homework1;

import java.util.*;

/**
 * LonelyNumber.java
 * @author Anton Smirnov
 * @version 01.11.2015
 * @java 7
 * @category homework1
 *
 */

public class LonelyNumber {
	public static void main(String[] args) {

		// Testing
		new LonelyNumber().startProgram();
	}

	public void startProgram() {
		String result = findLonelyNumber();
		printUserInsertedNumbersAndLonelyNumber(result);
	}

	// Setup input data by User
	private static int[] setupUserNumbers() {
		String instruction = "Please insert integer numbers (not less than 3 numbers) separated by spaces: ";
		System.out.println(instruction);

		while (true) {
			try {
				Scanner in = new Scanner(System.in);
				String tempText = in.nextLine();
				String[] inputUserText = tempText.split(" ");
				int[] userNumbers = new int[inputUserText.length];

				for (int barrier = 0; barrier < inputUserText.length; barrier++) {
					userNumbers[barrier] = Integer.parseInt(inputUserText[barrier]);
				}

				if (userNumbers.length < 3 || userNumbers.length > 20) {
					throw new Exception();
				} else {
					return userNumbers;
				}
			} catch (Exception e) {
				System.out.println("User inserted wrong value. Please try again." + System.lineSeparator() + instruction);
			}
		}
	}

	// Finding lonely number in storage of user's inserted numbers
	private String findLonelyNumber() {
		int[] userNumbers = setupUserNumbers();
		StringBuilder result = new StringBuilder();
		StringBuilder lonelyNumbers = new StringBuilder();

		result.append("User's inserted numbers ").append(Arrays.toString(userNumbers)).append(System.lineSeparator());
		Set<Integer> uniqueNumbers = findsAllUniqueUserNumbers(userNumbers);

		int counterOfLonelyNumbers = 0;
		for (int unigueNumber : uniqueNumbers) {
			int amountOfDuplicates = 0;

			for (int index = 0; index < userNumbers.length; index++) {
				if (unigueNumber == userNumbers[index]) {
					amountOfDuplicates++;
				}
			}

			if (amountOfDuplicates == 3) {
				counterOfLonelyNumbers++;
				lonelyNumbers.append(unigueNumber).append(" ");
			}
		}

		if (counterOfLonelyNumbers == 0) {
			result.append("There is no lonely number in user's inserted numbers");
		} else if (counterOfLonelyNumbers == 1) {
			result.append("Lonely number: ").append(lonelyNumbers);
		} else {
			result.append("There are more than one lonely numbers. These numbers are: ").append(lonelyNumbers);
		}

		return result.toString();
	}

	// Finding all unique numbers in storage of user's inserted numbers
	private HashSet<Integer> findsAllUniqueUserNumbers(int[] userNumbers) {
		HashSet<Integer> uniqueNumbers = new HashSet<>();
		for (Integer number : userNumbers) {
			uniqueNumbers.add(number);
		}
		return uniqueNumbers;
	}

	// Printing into console user's inserted numbers and lonely number
	private void printUserInsertedNumbersAndLonelyNumber(String result) {
		System.out.println(result);
	}
}
