package homework1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * LongDivision.java
 * @author Anton Smirnov
 * @version 01.11.2015
 * @java 7
 * @category homework1
 *
 */

public class LongDivision {
	public static void main(String[] args) {

		// Testing
		new LongDivision().startProgram();
	}

	public void startProgram() {
		printDividingProcessAndResult();
	}

	// Setup input data by User
	private int[] setupUserNumbers() {
		while (true) {
			try {
				int[] userNumbers = new int[2];
				Scanner in = new Scanner(System.in);

				System.out.print("Please insert first number: ");
				int inputFirstNumber = in.nextInt();
				userNumbers[0] = inputFirstNumber;

				System.out.print("Please insert second number: ");
				int inputSecondNumber = in.nextInt();
				userNumbers[1] = inputSecondNumber;

				return userNumbers;
			} catch (Exception e) {
				System.out.println("User insert wrong value. Please try again.");
			}
		}
	}

	
	// Dividing first user's inserted number on second user's inserted number
	private String divideFirstNumberOnSecondNumber() {
		int[] userNumbers = setupUserNumbers();
		int firstNumber = userNumbers[0];
		int secondNumber = userNumbers[1];

		StringBuilder result = new StringBuilder();
		StringBuilder divingProcess = new StringBuilder();
		String space = " ";
		char oneSpace = ' ';

		// Activities if first input value dividing on second input value WITHOUT remainder
		if (firstNumber % secondNumber == 0) {
			result.append(firstNumber / secondNumber);
			saveEveryDividingSteps(divingProcess, firstNumber, secondNumber, space);
		} else {

			// Activities if first input value dividing on second input value WITH remainder
			if (firstNumber > secondNumber && firstNumber % secondNumber != 0) {
				saveEveryDividingSteps(divingProcess, firstNumber, secondNumber, space);
				result.append(firstNumber / secondNumber);
				firstNumber = firstNumber - secondNumber * (firstNumber / secondNumber);
				space = space + oneSpace;
			}

			if (result.toString().isEmpty()) {
				result.append("0.");
			} else {
				result.append(".");
			}

			while (firstNumber % secondNumber != 0 && result.length() < 20) {
				firstNumber = firstNumber * 10;

				if (firstNumber < secondNumber) {
					result.append("0");
				} else {
					int tempResultDividing = firstNumber / secondNumber;
					saveEveryDividingSteps(divingProcess, firstNumber, secondNumber, space);
					firstNumber = firstNumber - secondNumber * tempResultDividing;
					result.append(tempResultDividing);
					space += oneSpace;
				}
			}
		}
		divingProcess.append(space).append(" result is: ").append(result);
		return divingProcess.toString();
	}

	
	// Printing into console every steps of dividing process and result
	private void printDividingProcessAndResult() {
		String result = divideFirstNumberOnSecondNumber();
		System.out.println(result);
	}

	
	// Saving every steps from dividing process
	private void saveEveryDividingSteps(StringBuilder divingProcess, int firstNumber, int secondNumber, String space) {
		String separator = "------";
		char oneSpace = ' ';
		char underscore = '_';

		if (firstNumber % secondNumber == 0) {

			divingProcess.append(space).append(underscore).append(firstNumber).append(System.lineSeparator())
					.append(space).append(oneSpace).append(firstNumber).append(System.lineSeparator()).append(space)
					.append(separator).append(System.lineSeparator());

		} else {
			divingProcess.append(space).append(underscore).append(firstNumber).append(System.lineSeparator())
					.append(space).append(oneSpace).append(secondNumber * (firstNumber / secondNumber))
					.append(System.lineSeparator()).append(space).append(separator).append(System.lineSeparator());
		}
	}
}
