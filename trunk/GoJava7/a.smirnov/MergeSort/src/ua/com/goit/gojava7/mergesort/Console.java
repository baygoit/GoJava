package ua.com.goit.gojava7.mergesort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Console {
	
	public static void main(String[] args) {
		Console con = new Console();
		con.start();
		System.out.println(con.getStorageOfUserNumbers());
	}
	
	private int[] storageOfNumbersFromUser;
	private static final String INSTRUCTION_STARTING_MENU = "Please make choose:\n" 
											+ " 1. Automatic generation of numbers \n"
											+ " 2. Manual generation of numbers \n" 
											+ " 3. Quit the program";
	
	private static final String INSTRUCTION_FOR_MANUAL = "Please enter integer numbers "
											+ "(not more than 20) separated by spaces:"; 
	private static final String INSTRUCTION_FOR_AUTOMATICAL = "Please enter desired amount "
											+ "(not more than 20) of generated numbers:";
	private static final String SEPARATOR = "=========================";
	private static final Random RANDOM = new Random();

	private boolean flagOne = true;
	private boolean flagTwo = true;

	
	public void start() {
		while (flagOne) {
			System.out.println(INSTRUCTION_STARTING_MENU + "\n" + SEPARATOR);
			try {
				Scanner in = new Scanner(System.in);
				String userInputedString = in.nextLine();
				System.out.println(SEPARATOR);

				switch (userInputedString.charAt(0)) {
					case '1': {
						getAutomaticGenereGeneratedNumbers();
						flagOne = false;
					}
						break;
					case '2': {
						getNumbersFromUser();
						flagOne = false;
					}
						break;
					case '3': {
						System.out.println("Good buy");
						System.exit(1);
					}
						break;
					default: {
						System.out.println("You chose mismatch item. So try again");
					}
				}
			} catch (Exception e) {
				System.out.println("Sorry, An unexpected exception....");
			}
		}
	}

	private void getNumbersFromUser() {
		while (flagTwo) {
			System.out.println(INSTRUCTION_FOR_MANUAL);
			try {
				Scanner in = new Scanner(System.in);
				String userInputedString = in.nextLine();
				String[] storageOfNonparsingInputedValues = userInputedString.split(" ");
				int amountOfInputedValues = storageOfNonparsingInputedValues.length;
				storageOfNumbersFromUser = new int[amountOfInputedValues];

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
				System.out.println("You entered forbidden symbols. So, try again");
			}
		}
	}

	private void getAutomaticGenereGeneratedNumbers() {
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
				System.out.println("You entered forbidden symbols. So, try again");
			}
		}
	}

	public void print(int[] array) {
		System.out.println(Arrays.toString(array));
	}
	
	public int[] getStorageOfUserNumbers () {
		return storageOfNumbersFromUser;
	}
	
}
