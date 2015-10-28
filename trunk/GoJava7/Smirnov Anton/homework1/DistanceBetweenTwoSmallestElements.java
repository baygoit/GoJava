package homework1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * DistanceBetweenTwoSmallestElements.java
 * 
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

	// Method searching all smallest and second smallest elements in input array
	public void findDistancesBetweenSmallestElements(int[] array) {

		// Maps for saving all smallest and second smallest elements and their indexes
		Map<Integer, Integer> mapOfSmallestElements = new HashMap<>();
		Map<Integer, Integer> mapOfSecondSmallestElements = new HashMap<>();
		int value = 0;
		int smallestElement = array[0];
		int secondSmallestElement = Integer.MAX_VALUE;

		// Searching the smallest element in input array
		for (int barrier = 0; barrier < array.length; barrier++) {
			if (smallestElement > array[barrier]) {
				smallestElement = array[barrier];
			}
		}

		// Putting all smallest elements in map of smallest elements
		for (int barrier = 0; barrier < array.length; barrier++) {
			if (smallestElement == array[barrier]) {
				mapOfSmallestElements.put(barrier, smallestElement);
			}
		}

		// Searching the second smallest element after [smallestElement]
		for (int barrier = 0; barrier < array.length; barrier++) {
			if (secondSmallestElement > array[barrier] && array[barrier] > smallestElement) {
				secondSmallestElement = array[barrier];
			}
		}

		// Putting all second smallest elements in map of smallest elements
		for (int barrier = 0; barrier < array.length; barrier++) {
			if (secondSmallestElement == array[barrier]) {
				mapOfSecondSmallestElements.put(barrier, secondSmallestElement);
			}
		}

		if (secondSmallestElement == Integer.MAX_VALUE) {
			System.out.println("There is no second smallest element in array."
					+ " Array has all equals elements. This element [" + smallestElement + "]");
		}
		printAllDistanceBetweenTwoSmallestElements(mapOfSmallestElements, mapOfSecondSmallestElements);
	}

	// Method print into console distances between smallest elements
	public void printAllDistanceBetweenTwoSmallestElements(Map<Integer, Integer> mapOfSmallestElements,
			Map<Integer, Integer> mapOfSecondSmallestElements) {

		for (Map.Entry<Integer, Integer> firstEntry : mapOfSmallestElements.entrySet()) {
			for (Map.Entry<Integer, Integer> secondEntry : mapOfSecondSmallestElements.entrySet()) {
				System.out.println(
						"Distance between elements [" + firstEntry.getValue() + "] and [" + secondEntry.getValue()
								+ "] is: " + (Math.abs(firstEntry.getKey() - secondEntry.getKey())));
			}
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
				int[] inputValues = new int[arrayOfUsersNumbers.length];

				// Parsing every value from string array and adding to integer
				// array
				for (int barrier = 0; barrier < arrayOfUsersNumbers.length; barrier++) {
					inputValues[barrier] = Integer.parseInt(arrayOfUsersNumbers[barrier]);
				}

				// Checking array capacity
				if (inputValues.length == 0) {
					System.out.println("Array is empty."
							+ " Please, insert one more time integer numbers separated by spaces for array: ");
				} else if (inputValues.length == 1 || inputValues.length > 20) {
					System.out.println("Incorrect amount of elements in array. Array has only one lemenet: "
							+ Arrays.toString(inputValues) + "." + System.lineSeparator()
							+ "Please, insert one more time integer numbers separated by spaces for array:  ");
				} else {
					System.out.println("User insert array " + Arrays.toString(inputValues));
					return inputValues;
				}
			} catch (Exception e) {
				System.out.println("User insert wrong value."
						+ " Please, insert one more time integer numbers separated by spaces for array:  ");
			}
		}
	}
}
