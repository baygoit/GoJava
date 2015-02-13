package ua.com.scread.kickstarter;

import java.util.Scanner;

public class ConsoleIO implements IO {

	private Scanner scanner;
	
	public ConsoleIO() {
		scanner = new Scanner(System.in);
	}
	
	@Override
	public int read() {
		return scanner.nextInt();
	}
	
	protected void finalize() throws Throwable {
		scanner.close();
	}
	
	@Override
	public void print(String message) {
		System.out.print(message);
	}
	
	@Override
	public String readString() {
	    return scanner.nextLine();
	}
	
	@Override
	public long readLong() {
	    return scanner.nextLong();
	}
}
