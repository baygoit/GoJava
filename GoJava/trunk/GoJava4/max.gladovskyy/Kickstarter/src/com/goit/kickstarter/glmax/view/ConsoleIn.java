package com.goit.kickstarter.glmax.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleIn implements Input {

	private int userChoise;
	
	public int getValidatedUserChois(int variantsAmount) {
		getIntFromUser();
		validateUserChoise(variantsAmount);
		return userChoise;
	}
	
	public int getNotValidatedUserChois() {
		getIntFromUser();
		return userChoise;
	}
	

	private void getIntFromUser() {
		System.out.println("Make a choise:");
		Scanner scaner = new Scanner(System.in);
		try {
			userChoise = scaner.nextInt();

		} catch (InputMismatchException e) {
			System.err.println("You entered not a number. Try Again.");
			getIntFromUser();
		}
	}

	private void validateUserChoise(int variantsAmount) {
		if (userChoise < 0 || userChoise > (variantsAmount - 1)) {
			System.out.println("There no such variant. Try Again.");
			getIntFromUser();
			validateUserChoise(variantsAmount);
		} 
	}

}
