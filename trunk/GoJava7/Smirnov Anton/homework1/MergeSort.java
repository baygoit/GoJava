package homework1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * MergeSort.java
 * 
 * @author Anton Smirnov
 * @version 22.10.2015
 * @java 7
 * @category homework1
 *
 */

public class MergeSort {
	public static void main(String[] args) {

		// Testing
		new MergeSort().printSortedArray();
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

	// Method allowing user set up input data for program
	public static int[] setUpUserInputData() {
		System.out.println("Please insert integer numbers for array separated by spaces: ");

		// Handling of user's input data
		while (true) {
			try {
				Scanner input = new Scanner(System.in);
				String inputUserString = input.nextLine();
				String[] arrayOfUsersNumbers = inputUserString.split(" ");
				int[] array = new int[arrayOfUsersNumbers.length];

				// Parsing every value from string array and adding to integer
				// array
				for (int barrier = 0; barrier < arrayOfUsersNumbers.length; barrier++) {
					array[barrier] = Integer.parseInt(arrayOfUsersNumbers[barrier]);
				}

				// Printing into console the user's input array
				System.out.println("User input array: " + Arrays.toString(array));

				return array;
			} catch (Exception e) {
				System.out.println("User insert wrong value."
						+ " Please, insert one more time integer numbers separated by spaces for array:  ");
			}
		}
	}

	/* Method prints into console the sorted user's input array */
	public void printSortedArray() {
		System.out.println("Array after sorting: " + Arrays.toString(sortMerge(setUpUserInputData())));
	}

}
