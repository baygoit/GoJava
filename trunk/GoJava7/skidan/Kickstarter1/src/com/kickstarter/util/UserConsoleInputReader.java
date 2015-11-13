package com.kickstarter.util;

import java.util.Scanner;

public class UserConsoleInputReader {

	static int input;

	public static int readInput() {
		try {
			Scanner sc = new Scanner(System.in);
			input = sc.nextInt();

		} catch (Exception e) {
			System.out.println("Please input didgits, not leters");
			readInput();
		}
		return input;

	}

	public static String readStringInput() {
		String name = "";
		try {
			Scanner sc = new Scanner(System.in);
			name = sc.nextLine();
			if (name.getClass().equals(String.class) == false)
				throw new Exception();
		} catch (Exception e) {
			System.out.println("Input leters Please. Check your Input");
			readStringInput();
		}
		return name;
	}

}