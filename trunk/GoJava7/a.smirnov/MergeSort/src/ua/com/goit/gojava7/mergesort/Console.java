package ua.com.goit.gojava7.mergesort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Console {
	// Eugene: You are saving user array in memory as long you use instance of 'Console' class. Why? Do you need it for something?
	private int[] storageOfNumbersFromUser;
	// Eugene: "Please, make a choice" or "Please, choose one option"
	private static final String INSTRUCTION_STARTING_MENU = "Please make choose:\n"
	// Eugene: Just numbers or array of numbers?		
			+ " 1. Automatic generation of numbers \n" 
			+ " 2. Manual generation of numbers \n" 
			+ " 3. Quit the program";

	// Eugene: why not more?	
	private static final String INSTRUCTION_FOR_MANUAL = "Please enter integer numbers "
			+ "(not more than 20) separated by spaces:";
	private static final String INSTRUCTION_FOR_AUTOMATICAL = "Please enter desired amount "
			+ "(not more than 20) of generated numbers:";
	private static final String SEPARATOR = "=========================";
	private static final Random RANDOM = new Random();

	// Eugene: That's not a speaking name. I can't understand what is it for without code analysis
	private boolean flagOne = true;
	// Eugene: Same here
	private boolean flagTwo = true;

	// Eugene: Maybe a bit broken SRP - 'start' is doing Out, In and some input-processing logic 	
	public void start() {
		while (flagOne) {
			System.out.println(INSTRUCTION_STARTING_MENU + "\n" + SEPARATOR);
			// Eugene: You use 'new Scanner' in 3 different places, but never closed any of them
			// Eugene: Maybe you can use try-with-resources?)
			try {
				Scanner in = new Scanner(System.in);
				String userInputedString = in.nextLine();
				System.out.println(SEPARATOR);

				switch (userInputedString.charAt(0)) {
					case '1': {
						getAutomaticGeneratedNumbers();
						flagOne = false;
					}
						break;
					case '2': {
						getNumbersFromUser();
						flagOne = false;
					}
						break;
					case '3': {
						// Eugene: 'Good bye', you 'buy' goods:) 
						System.out.println("Good buy");
						// Eugene: I don't know exactly, but it seems that exit in this way is not a good practice. Maybe I'm wrong...
						System.exit(1);
					}
						break;
					default: {
						System.out.println("You chose mismatch item. So try again");
					}
				}
			// Eugene: It's not a good practice - to generalize all Exceptions into one
			} catch (Exception e) {
				System.out.println("Sorry, An unexpected exception....");
			}
		}
	}

	// Eugene:  'get' in name, but void? 
	private void getNumbersFromUser() {
		while (flagTwo) {
			System.out.println(INSTRUCTION_FOR_MANUAL);
			try {
				Scanner in = new Scanner(System.in);
				String userInputedString = in.nextLine();
				// Eugene: " " - magic String!
				String[] storageOfNonparsingInputedValues = userInputedString.split(" ");
				int amountOfInputedValues = storageOfNonparsingInputedValues.length;
				storageOfNumbersFromUser = new int[amountOfInputedValues];

				// Eugene: why only 20? And what is 20? Magic number?
				if (amountOfInputedValues > 20) {
					System.out.println("You entered to much many numbers. Limit: 20 numbers. So, try again");
				} else if (amountOfInputedValues == 0) {
					System.out.println("You did not enter any number. So, try again");
				} else {
					for (int index = 0; index < amountOfInputedValues; index++) {
						storageOfNumbersFromUser[index] = Integer.parseInt(storageOfNonparsingInputedValues[index]);
					}
					flagTwo = false;
				}
			} catch (Exception e) {
				// Eugene: You have the same in 'getAutomaticGeneratedNumbers'
				System.out.println("You entered forbidden symbols. So, try again");
			}
		}
	}

	private void getAutomaticGeneratedNumbers() {
		while (flagTwo) {
			System.out.println(INSTRUCTION_FOR_AUTOMATICAL);
			try {
				Scanner in = new Scanner(System.in);
				int amountOfInputedValues = in.nextInt();
				if (amountOfInputedValues > 20) {
					System.out.println("You want to  generate to many numbers. Limit: 20 numbers. So, try again");
				} else if (amountOfInputedValues == 0) {
					System.out.println("You entered 0...Do you want to generate numbers? So, try again");
				} else {
					storageOfNumbersFromUser = new int[amountOfInputedValues];
					for (int index = 0; index < amountOfInputedValues; index++) {
						storageOfNumbersFromUser[index] = RANDOM.nextInt(amountOfInputedValues);
					}
					flagTwo = false;
				}
			} catch (Exception e) {
				// Eugene: You have the same in 'getAutomaticGeneratedNumbers'
				System.out.println("You entered forbidden symbols. So, try again");
			}
		}
	}

	public void print(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	public int[] getStorageOfUserNumbers() {
		return storageOfNumbersFromUser;
	}

}
