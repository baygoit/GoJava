package homework1;

import java.util.Scanner;

public class StringReverse {
	public static void main(String[] args) {

		// Testing
		new StringReverse().reverseString(setUpUserInputData());
	}

	/* Method reversing input user's text */
	public void reverseString(String inputUsersText) {

		// Converting input string into char array
		char[] array = inputUsersText.toCharArray();

		StringBuilder tempWord = new StringBuilder();
		StringBuilder finishText = new StringBuilder();

		// Loop over user input string
		for (int step = 0; step < array.length; step++) {

			// Checking of every element in input string
			if (array[step] >= 'a' && array[step] <= 'z' || array[step] >= 'A' && array[step] <= 'Z') {

				// Adding to temporary variable
				tempWord.append(array[step]);

				// Checking of step value
				if (step == array.length - 1) {
					finishText.append(tempWord.reverse());
				}
			} else {

				// Checking of capacity of temporary string
				if (tempWord.toString().isEmpty()) {

					// Adding element to finish string
					finishText.append(array[step]);
				} else {

					// Reversing of temporary string and adding to finish string
					finishText.append(tempWord.reverse());

					// Deleting all elements from temporary string
					tempWord.delete(0, tempWord.length());

					// Adding element to finish string
					finishText.append(array[step]);
				}
			}
		}
		printReversedText(inputUsersText, finishText);
	}
	
	// Method prints into console reversed text
	public void printReversedText(String inputText, StringBuilder reversedText) {
		System.out.println("User input text: " + inputText + System.lineSeparator()
							+ "Reversed text: " + reversedText.toString());
	}

	public static String setUpUserInputData() {
		System.out.println("Please input text: ");
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

}
