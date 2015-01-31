package ua.home.kickstarter;

import java.util.Scanner;

public class InOut {
	public int input() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	public void output(String s) {
		System.out.println(s);
	}
}
