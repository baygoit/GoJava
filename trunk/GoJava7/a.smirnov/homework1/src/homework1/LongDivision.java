package homework1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * LongDivision.java
 * @author Anton Smirnov
 * @version 22.10.2015
 * @java 7
 * @category homework1
 *
 */

public class LongDivision {
	public static void main(String[] args) {

		// Testing
		new LongDivision().divide(setUpUserInputData());
	}

	// Method divides first user's input number on second user's input number
	public void divide(int[] storageOfUserInputNumbers) {

		int firstNumber = storageOfUserInputNumbers[0];
		int secondNumber = storageOfUserInputNumbers[1];

		// Storage for all numbers from dividing process
		List<Integer> storageOfAllNumeratorsAndDenominator = new ArrayList<>();

		// Result from dividing process
		String result = "";

		// Activities if first input value dividing on second input value WITHOUT remainder
		if (firstNumber % secondNumber == 0) {
			result = result + firstNumber / secondNumber;
			storageOfAllNumeratorsAndDenominator.add(firstNumber);
			storageOfAllNumeratorsAndDenominator.add(secondNumber);

			printDividingProcessIntoConsole(storageOfAllNumeratorsAndDenominator, result);

			
		} else {

			// Activities if first input value dividing on second input value WITH remainder
			if (firstNumber > secondNumber && firstNumber % secondNumber != 0) {
				storageOfAllNumeratorsAndDenominator.add(firstNumber);
				int tempResultDividing = firstNumber / secondNumber;
				storageOfAllNumeratorsAndDenominator.add(secondNumber * tempResultDividing);
				result = result + tempResultDividing;
				firstNumber = firstNumber - secondNumber * tempResultDividing;
			}

			// Checking of result from dividing
			if (result.isEmpty()) {
				result = result + "0.";
			} else {
				result = result + ".";
			}

			while (firstNumber % secondNumber != 0 && result.length() < 20) {
				firstNumber = firstNumber * 10;

				if (firstNumber < secondNumber) {
					result = result + "0";
				} else {
					storageOfAllNumeratorsAndDenominator.add(firstNumber);
					int tempResultDividing = firstNumber / secondNumber;
					firstNumber = firstNumber - secondNumber * tempResultDividing;
					result = result + tempResultDividing;
					storageOfAllNumeratorsAndDenominator.add(secondNumber * tempResultDividing);
				}
			}
		}

		printDividingProcessIntoConsole(storageOfAllNumeratorsAndDenominator, result);
	}

	// Method allows user to set up data
	public static int[] setUpUserInputData() {
		// Handling of user's input data
		while (true) {
			try {
				int[] storageOfUserInputNumbers = new int[2];
				Scanner in = new Scanner(System.in);

				// Checking of first user's input number and adding to storage of user's input numbers
				System.out.println("Please insert first value: ");
				int inputFirstNumber = in.nextInt();
				storageOfUserInputNumbers[0] = inputFirstNumber;

				// Checking of second user's input number and adding to storage of user's input numbers
				System.out.println("Please insert second value: ");
				int inputSecondNumber = in.nextInt();
				storageOfUserInputNumbers[1] = inputSecondNumber;

				System.out.println("User wants divide " + inputFirstNumber + " on " + inputSecondNumber);
				return storageOfUserInputNumbers;
			} catch (Exception e) {
				System.out.println("User insert wrong value. Please try again");
			}
		}

	}

	// Methods prints every steps of dividing process into console 
	public void printDividingProcessIntoConsole(List<Integer> list, String result) {
		String space = " ";
		String separator = "------";
		char oneSpace = ' ';
		char underscore = '_';

		StringBuilder finishLine = new StringBuilder();
		for (int barrier = 0; barrier < list.size() - 1; barrier = barrier + 2) {
			finishLine.append(space + underscore + list.get(barrier)).append(System.lineSeparator())
					.append(space + oneSpace + list.get(barrier + 1)).append(System.lineSeparator())
					.append(space + separator).append(System.lineSeparator());
			space = space + "  ";
		}
		System.out.println(finishLine.toString() + System.lineSeparator() + space + " result is: " + result);
	}
}
