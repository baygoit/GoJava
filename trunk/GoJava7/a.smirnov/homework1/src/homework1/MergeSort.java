package homework1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * MergeSort.java
 * @author Anton Smirnov
 * @version 22.10.2015
 * @java 7
 * @category homework1
 *
 */

public class MergeSort {
	public static void main(String[] args) {

		// Testing
		new MergeSort().printInputNumbersAndSortedNumbers(setUpUserInputData());
	}

	// Method sorts input array and returns new sorted one
	public int[] sortMerge(int[] array) {

		// Checking the input array's capacity
		if (array.length < 2) {
			return array;
		}

		// Finding the middle value of array length
		int middleOfArrayLength = array.length / 2;

		// Using adding method "merge"
		return merge(sortMerge(Arrays.copyOfRange(array, 0, middleOfArrayLength)),
				sortMerge(Arrays.copyOfRange(array, middleOfArrayLength, array.length)));
	}

	// Method sorts two arrays and merges its elements in one array
	public int[] merge(int[] firstArray, int[] secondArray) {

		int firstIndex = 0, secondIndex = 0; // Counters loop

		// New array for merging all elements from two input arrays
		int[] result = new int[firstArray.length + secondArray.length];

		// Scamper over new array
		for (int barrier = 0; barrier < result.length; barrier++) {

			// Checking the limit of counters loop
			if (secondIndex < secondArray.length && firstIndex < firstArray.length) {

				// Comparison elements of two input arrays
				if (firstArray[firstIndex] > secondArray[secondIndex]) {

					// Adding element to result array and increasing of second
					// counter loop on 1
					result[barrier] = secondArray[secondIndex++];
				} else {

					// Adding element to result array and increasing of first
					// counter loop on 1
					result[barrier] = firstArray[firstIndex++];
				}
			} else if (secondIndex < secondArray.length) {

				// Adding element to result array and increasing of second
				// counter loop on 1
				result[barrier] = secondArray[secondIndex++];
			} else {

				// Adding element to result array and increasing of first
				// counter loop on 1
				result[barrier] = firstArray[firstIndex++];
			}
		}
		return result;
	}

	// Method allows user to set up data
	public static int[] setUpUserInputData() {
		String greetings = "Please insert integer numbers for array separated by spaces: ";
		System.out.println(greetings);

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
				
				return storageOfUsersInputNumbers;
			} catch (Exception e) {
				System.out.println("User insert wrong value. Please, try again " 
							+ System.lineSeparator() + greetings);
			}
		}
	}

	// Method prints into console sorted user's input numbers
	public void printInputNumbersAndSortedNumbers(int[] storageOfUserInputNumbers) {
		System.out.println("User's input numbers: " + Arrays.toString(storageOfUserInputNumbers));
		System.out.println("Sorted user's numbers: " + Arrays.toString(sortMerge(storageOfUserInputNumbers)));
	}

}
