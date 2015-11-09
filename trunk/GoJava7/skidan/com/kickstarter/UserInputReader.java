package com.kickstarter;

import java.util.Scanner;

public class UserInputReader {

	static int input;
    static String name;
	public static int read() {
		try {
			Scanner sc = new Scanner(System.in);
			input = sc.nextInt();

		} catch (Exception e) {
			System.out.println("No such category or project avaliable. Check your Input");
			read();
		}
		return input;

	}
	public static String readString() {
		try {
			Scanner sc = new Scanner(System.in);
			name = sc.nextLine();

		} catch (Exception e) {
			System.out.println("No such category or project avaliable. Check your Input");
			read();
		}
		return name;

	}
}
