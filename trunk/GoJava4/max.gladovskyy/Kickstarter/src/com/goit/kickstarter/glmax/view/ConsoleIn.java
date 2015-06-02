package com.goit.kickstarter.glmax.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleIn implements Input {

	private int userChoise;

	@Override
	public void getIntFromUser() {
		System.out.println("Make a choise:");
		Scanner scaner = new Scanner(System.in);
		try {
			int result = scaner.nextInt();

		} catch (InputMismatchException e) {
			System.err.println("You entered not a number. Try Again.");
			getIntFromUser();
		}
	}

	public void validateUserChoise(int variantsAmount) {
		if (userChoise < 0 || userChoise > variantsAmount) {
		} else {
			System.out.println("There no such variant. Try Again.");
			getIntFromUser();
			validateUserChoise(variantsAmount);
		}
	}

	public String getStringFromUser() {
		Scanner scaner = new Scanner(System.in);
		return scaner.nextLine();
	}

	public int getUserChoise() {
		return userChoise;
	}

}
