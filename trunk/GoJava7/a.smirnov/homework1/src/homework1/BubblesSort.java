package homework1;

import java.util.Arrays;
import java.util.Scanner;

public class BubblesSort {
	public static void main(String[] args) {
		
		// Testing
		new BubblesSort().startProgram();
	}

	public void startProgram() {
		int[] userNumbers = setupUserNumbers();
		printInsertedNumbers(userNumbers);
		printSortedNumbers(userNumbers);
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
				System.out.println(
						"User inserted wrong value. " + "Please try again." + System.lineSeparator() + instruction);
			}
		}
	}

	// Sorting user's inserted numbers
	private int[] bubblesSort(int[] userNumbers) {
		for (int barrier = userNumbers.length - 1; barrier > 0; barrier--) {
			for (int index = 0; index < barrier; index++) {
				if (userNumbers[index] > userNumbers[index + 1]) {
					int temp = userNumbers[index];
					userNumbers[index] = userNumbers[index + 1];
					userNumbers[index + 1] = temp;

				}
			}
		}
		return userNumbers;
	}

	// Printing into console user's inserted numbers
	private void printInsertedNumbers(int[] userNumbers) {
		System.out.println("User's inserted numbers: " + Arrays.toString(userNumbers));
	}

	// Printing into console user's sorted numbers
	private void printSortedNumbers(int[] userNumbers) {
		System.out.println("User's sorted numbers: " + Arrays.toString(bubblesSort(userNumbers)));
	}

}
