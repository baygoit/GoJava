package homework1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * MergeSort.java
 * 
 * @author Anton Smirnov
 * @version 03.11.2015
 * @java 7
 * @category homework1
 *
 */

public class MergeSort {
	public static void main(String[] args) {

		// Testing
		new MergeSort().startProgram();
	}

	public void startProgram() {
		int[] userNumbers = setupUserNumbers();

		// Printing into console user's inserted numbers
		printInsertedNumbers(userNumbers);

		// Sorting user's inserted numbers
		int[] sortedNumbers = sortMerge(userNumbers);

		// Printing into console sorted numbers
		printSortedNumbers(sortedNumbers);
	}

	// Setup input data by User
	private int[] setupUserNumbers() {
		String instruction = "Please insert integer numbers " + "(not more than 20 numbers) separated by spaces: ";
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

				if (userNumbers.length > 20 || userNumbers.length == 0) {
					throw new Exception();
				} else {
					return userNumbers;
				}
			} catch (Exception e) {
				System.out.println("User inserted wrong value. " 
									+ "Please try again." 
									+ System.lineSeparator() + instruction);
			}
		}
	}

	// Dividing user storage of numbers on two halves and sorting its
	private int[] sortMerge(int[] UserNumbers) {
		if (UserNumbers.length < 2) {
			return UserNumbers;
		}
		int middleOfArrayLength = UserNumbers.length / 2;

		return merge(sortMerge(Arrays.copyOfRange(UserNumbers, 0, middleOfArrayLength)),
				sortMerge(Arrays.copyOfRange(UserNumbers, middleOfArrayLength, UserNumbers.length)));
	}

	// Merging two sorted arrays in one general
	private int[] merge(int[] firstArray, int[] secondArray) {

		int indexOfFirstArray = 0, indexOfSecondArray = 0;
		int[] result = new int[firstArray.length + secondArray.length];

		for (int barrier = 0; barrier < result.length; barrier++) {
			if (indexOfSecondArray < secondArray.length && indexOfFirstArray < firstArray.length) {
				if (firstArray[indexOfFirstArray] > secondArray[indexOfSecondArray]) {
					result[barrier] = secondArray[indexOfSecondArray++];
				} else {
					result[barrier] = firstArray[indexOfFirstArray++];
				}
			} else if (indexOfSecondArray < secondArray.length) {
				result[barrier] = secondArray[indexOfSecondArray++];
			} else {
				result[barrier] = firstArray[indexOfFirstArray++];
			}
		}
		return result;
	}

	// Printing into console user's inserted numbers
	private void printInsertedNumbers(int[] userNumbers) {
		System.out.println("User's inserted numbers: " + Arrays.toString(userNumbers));
	}

	// Printing into console user's sorted numbers
	private void printSortedNumbers(int[] sortedNumbers) {
		System.out.println("User's sorted numbers: " + Arrays.toString(sortedNumbers));
	}

}
