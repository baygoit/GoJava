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

	// Method showing dividing process
	public void divide(int[] inputValues) {

		int firstValue = inputValues[0];
		int secondValue = inputValues[1];

		// List of elements from dividing (step by step)
		List<Integer> listOfAllNumeratorsAndDenominator = new ArrayList<>();

		// Result from dividing firstValue on secondValue
		String result = "";

		// Activities if first input value dividing on second input value
		// WITHOUT remainder of the division
		if (firstValue % secondValue == 0) {
			result = result + firstValue / secondValue;
			listOfAllNumeratorsAndDenominator.add(firstValue);
			listOfAllNumeratorsAndDenominator.add(secondValue);

			// Printing in console every step of dividing process
			printDividingProcessIntoConsole(listOfAllNumeratorsAndDenominator, result);

			// Activities if first input value dividing on second input value
			// WITH remainder of the division
		} else {

			// Activities if first input value bigger than second input value
			if (firstValue > secondValue && firstValue % secondValue != 0) {
				listOfAllNumeratorsAndDenominator.add(firstValue);
				int temp = firstValue / secondValue;
				listOfAllNumeratorsAndDenominator.add(secondValue * temp);
				result = result + temp;
				firstValue = firstValue - secondValue * temp;
			}

			// Checking of result string's capacity and adding of strings "0."
			// or "."
			if (result.isEmpty()) {
				result = result + "0.";
			} else {
				result = result + ".";
			}

			while (firstValue % secondValue != 0 && result.length() < 20) {
				firstValue = firstValue * 10;

				if (firstValue < secondValue) {
					result = result + "0";
				} else {
					listOfAllNumeratorsAndDenominator.add(firstValue);
					int temp = firstValue / secondValue;
					result = result + temp;
					firstValue = firstValue - secondValue * temp;
					listOfAllNumeratorsAndDenominator.add(secondValue * temp);
				}
			}
		}

		// Printing in console every step of dividing process
		printDividingProcessIntoConsole(listOfAllNumeratorsAndDenominator, result);
	}

	// Method allowing user set up input data for program
	public static int[] setUpUserInputData() {

		// Handling of user's input data
		while (true) {
			try {
				int[] inputValues = new int[2];
				Scanner input = new Scanner(System.in);

				// Checking of user's first input value (numerator) and adding
				// to array of input values
				System.out.println("Please insert first value: ");
				int inputFirstNumber = input.nextInt();
				inputValues[0] = inputFirstNumber;

				// Checking of user's second input value (denominator) and
				// adding to array of input values
				System.out.println("Please insert second value: ");
				int inputSecondNumber = input.nextInt();
				inputValues[1] = inputSecondNumber;

				System.out.println("User wants divide " + inputFirstNumber + " on " + inputSecondNumber);
				return inputValues;
			} catch (Exception e) {
				System.out.println("User insert wrong value. Please try again");
			}
		}

	}

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
