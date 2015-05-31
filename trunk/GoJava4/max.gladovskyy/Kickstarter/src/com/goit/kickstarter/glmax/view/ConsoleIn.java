package com.goit.kickstarter.glmax.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleIn implements Input {

	@Override
	public int getFromUser(ArrayList<Integer> menuEnteties) {
		System.out.println("Make a choise:");
		int userChoise = getUserChise(menuEnteties);
		return userChoise;
		}		


	private int getUserChise(ArrayList<Integer> variantsAmount) {
		Scanner scaner = new Scanner(System.in);
		try {
			int result = scaner.nextInt();
			if (variantsAmount.contains(result)) {
			return result;
			} else {
				System.out.println("There no such variant. Try Again.");
				return getUserChise(variantsAmount);
			}
		} catch (InputMismatchException e) {
			System.err.println("You entered not a number. Try Again.");
			return getUserChise(variantsAmount);
		}

	}

}
