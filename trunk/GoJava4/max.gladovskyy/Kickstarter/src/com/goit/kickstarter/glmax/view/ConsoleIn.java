package com.goit.kickstarter.glmax.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleIn implements Input {

	@Override
	public int getFromUser(int variantsAmount) {
		System.out.println("Make a choise:");
		int userChoise = getUserChise(variantsAmount);
		return userChoise;
		}		


	private int getUserChise(int maxVariant) {
		Scanner scaner = new Scanner(System.in);
		try {
			int result = scaner.nextInt();
			if (result >= 0 && result < maxVariant) {
			return result;
			} else {
				System.out.println("There no such variant. Try Again.");
				return getUserChise(maxVariant);
			}
		} catch (InputMismatchException e) {
			System.err.println("You entered not a number. Try Again.");
			return getUserChise(maxVariant);
		}
		finally {
			scaner.close();
		}

	}

}
