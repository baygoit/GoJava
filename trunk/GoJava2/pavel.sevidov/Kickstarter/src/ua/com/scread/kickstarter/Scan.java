package ua.com.scread.kickstarter;

import java.util.Scanner;

public class Scan {
	private Scanner scanner;
	
	public Scan() {
		scanner = new Scanner(System.in);
	}
	
	public int getAnswer() {
		return scanner.nextInt();
	}
	
	protected void finalize() throws Throwable {
		scanner.close();
	}

}
