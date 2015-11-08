package logic;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {

		String userName = null;
		Scanner in = new Scanner(System.in);

		System.out.println("Enter user Name: ");
		userName = in.nextLine();
		System.out.println("====================");
		System.out.println("Hello " + userName.toString() + "!");
		in.close();
	}

}
