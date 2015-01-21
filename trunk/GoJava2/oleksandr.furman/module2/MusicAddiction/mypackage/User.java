package mypackage;

import java.util.Scanner;


public class User {

	protected void userAuthorization() {
		System.out.println("Enter your user name:");
		Scanner scanner = new Scanner(System.in);
		String userName = scanner.nextLine();
		System.out.println("Welcome back " + userName + "!");
	}
}