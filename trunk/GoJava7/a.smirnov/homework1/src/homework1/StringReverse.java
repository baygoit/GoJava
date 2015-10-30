package homework1;

import java.util.Scanner;

public class StringReverse {
	public static void main(String[] args) {

		// Testing
		new StringReverse().reverseString(setUpUserInputData());
	}

	// Method reverses user's input text
	public void reverseString(String inputUserText) {

		// Converting input text into char array
		char[] storageOfAllCharsFromUserInputText = inputUserText.toCharArray();

		StringBuilder tempWord = new StringBuilder();
		StringBuilder finishText = new StringBuilder();

		// Loop over user input string
		for (int step = 0; step < storageOfAllCharsFromUserInputText.length; step++) {

			// Checking of every char in the storage
			if (storageOfAllCharsFromUserInputText[step] >= 'a' && storageOfAllCharsFromUserInputText[step] <= 'z' || storageOfAllCharsFromUserInputText[step] >= 'A' && storageOfAllCharsFromUserInputText[step] <= 'Z') {

				// Adding to temporary variable
				tempWord.append(storageOfAllCharsFromUserInputText[step]);

				// Checking of loop step 
				if (step == storageOfAllCharsFromUserInputText.length - 1) {
					finishText.append(tempWord.reverse());
				}
			} else {

				// Checking of capacity of temporary word
				if (tempWord.toString().isEmpty()) {

					// Adding char to finish text
					finishText.append(storageOfAllCharsFromUserInputText[step]);
				} else {

					// Reversing of temporary word and adding to finish text
					finishText.append(tempWord.reverse());

					// Deleting all chars from temporary word
					tempWord.delete(0, tempWord.length());

					// Adding char to finish text
					finishText.append(storageOfAllCharsFromUserInputText[step]);
				}
			}
		}
		printUserInptTextAndReversedText(inputUserText, finishText);
	}
	
	// Method prints into console reversed text
	public void printUserInptTextAndReversedText(String inputText, StringBuilder reversedText) {
		System.out.println("User's input text: " + inputText + System.lineSeparator()
							+ "Reversed user's text: " + reversedText.toString());
	}

	public static String setUpUserInputData() {
		System.out.println("Please input text: ");
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

}
