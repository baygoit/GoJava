package ua.com.goit.gojava7.mergesort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Console {

	private static final String STARTING_MENU = "Please, choose one option:\n" + " 1. Automatic generation numbers \n"
			+ " 2. Manual generation numbers \n" + " 3. Quit the program";

	private static final String INSTRUCTION_FOR_MANUAL_PROCESS = "Please enter integer numbers "
			+ "(not more than 20) separated by spaces:";
	private static final String INSTRUCTION_FOR_AUTOMATICAL_PROCESS = "Please enter desired amount "
			+ "(not more than 20) of generated numbers:";
	private static final String SEPARATOR = "=========================";
	private static final String ACTIVITY_IF_EXCEPTION = "You entered forbidden symbols. So, try again";
	private static final Random RANDOM = new Random();

	private int[] arrayOfUserInputedNumbers = null;
	private boolean flagForStartingMenu = true;
	private boolean flagForProcess = true;
	private Scanner in = null;

	public void showMenuForUser() {
		String userInputedString = "";
		while (flagForStartingMenu) {
			System.out.println(STARTING_MENU + "\n" + SEPARATOR);
			
			try {
				in = new Scanner(System.in);
				userInputedString = in.nextLine();
				System.out.println(SEPARATOR);

				switch (userInputedString.charAt(0)) {
					case '1': {
						flagForStartingMenu = false;
						generateAutomaticlyNumbers();
					}
						break;
					case '2': {
						flagForStartingMenu = false;
						generateNumbersFromUser();
					}
						break;
					case '3': {
						System.out.println("Good bye");
						System.exit(1);
					}
						break;
					default: {
						System.out.println("You chose mismatch option. So try again");
					}
				}

			} catch (Exception e) {
				System.out.println("ppppp");
			} 
		}
	}

	public void generateNumbersFromUser() {
		while (flagForProcess) {
			System.out.println(INSTRUCTION_FOR_MANUAL_PROCESS);
			try {
				in = new Scanner(System.in);
				String userInputedString = in.nextLine();
				String[] nonparsingInputedValues = userInputedString.split(" ");
				int amountOfInputedValues = nonparsingInputedValues.length;
				arrayOfUserInputedNumbers = new int[amountOfInputedValues];

				if (amountOfInputedValues > 25) {
					System.out.println("You entered to many numbers. Limit: 25 numbers. So, try again");
				} else if (amountOfInputedValues == 0) {
					System.out.println("You did not enter any number. So, try again");
				} else {
					for (int index = 0; index < amountOfInputedValues; index++) {
						arrayOfUserInputedNumbers[index] = Integer.parseInt(nonparsingInputedValues[index]);
					}
					flagForProcess = false;
				}
			} catch (Exception e) {
				System.out.println(ACTIVITY_IF_EXCEPTION);
			}
		}
	}

	public void generateAutomaticlyNumbers() {
		while (flagForProcess) {
			System.out.println(INSTRUCTION_FOR_AUTOMATICAL_PROCESS);
			try {
				in = new Scanner(System.in);
				int amountOfInputedValues = in.nextInt();
				if (amountOfInputedValues > 25) {
					System.out.println("You want to  generate to many numbers. Limit: 25 numbers. So, try again");
				} else if (amountOfInputedValues == 0) {
					System.out.println("You entered 0...Do you want to generate numbers? So, try again");
				} else {
					arrayOfUserInputedNumbers = new int[amountOfInputedValues];
					for (int index = 0; index < amountOfInputedValues; index++) {
						arrayOfUserInputedNumbers[index] = RANDOM.nextInt(amountOfInputedValues);
					}
					flagForProcess = false;
				}
			} catch (Exception e) {
				System.out.println(ACTIVITY_IF_EXCEPTION);
			}
		}
	}

	public void printInputedArray(int[] array) {
		System.out.println("User's inputed numbers:" + Arrays.toString(array));
	}
	
	public void printSortedArray(int[] array) {
		System.out.println("Sorted inputed numbers:" + Arrays.toString(array));
	}

	public int[] getInputedUserNumbers() {
		return arrayOfUserInputedNumbers;
	}
	
	public void closeScanner() {
		if (in != null) {
			in.close();
		}
	}

}
