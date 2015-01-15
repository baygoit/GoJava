package ua.com.goit.gojava1.iavorskyi.petproject;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		System.out.println("press 1 to login.");
		System.out.println("press 2 to register.");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String login = null;
		String password = null;
		String repeatPassword = null;
		
		if (input.equals("1")) {
			System.out.println("input login: ");
			login = in.next();
			System.out.println("input password: ");
			password = in.next();
			System.out.println("You are loged in.2");
		} else if (input.equals("2")) {
			System.out.println("input login: ");
			login = in.next();
			do {
			System.out.println("input password: ");
			password = in.next();
			System.out.println("repeat password: ");
			repeatPassword = in.next();
			if (!password.equals(repeatPassword)) {
				System.out.println("passwords does not match, please repeat.");
			}
			} while (!password.equals(repeatPassword));
			System.out.println("you are registered.");
		}
		
		in.close();

	}

}
