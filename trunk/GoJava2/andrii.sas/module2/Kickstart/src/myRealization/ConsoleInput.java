package myRealization;

import java.util.Scanner;

public class ConsoleInput implements Input {
	private Scanner scan;

	public int readChoice() {
		scan = new Scanner(System.in);
		return scan.nextInt();
	}
}
