package ua.com.goit.gojava.kickstarter.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputReader implements Reader {

	public String readUserInput() {
		String result = "0";
		try {
			result = new Scanner(System.in).next();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		System.out.println();
		return result;
	}
}
