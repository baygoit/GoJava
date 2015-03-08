package ua.com.sas.view;

import java.util.Scanner;

public class ConsoleInput implements Input {
	private Scanner scan;

	public String readChoice() {
		scan = new Scanner(System.in);
		return scan.nextLine();
	}
}
