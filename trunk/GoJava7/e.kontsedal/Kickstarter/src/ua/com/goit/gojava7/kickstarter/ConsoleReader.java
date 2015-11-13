package ua.com.goit.gojava7.kickstarter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
	private BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));

	public int getNumberFromConsole()
			throws IOException {
		do {
			String s = reader.readLine();
			try {
				return Integer.parseInt(s);	
			} catch (NumberFormatException e) {
				System.out.println("Write a number!");
				continue;
			}
		} while (true);
		
	}
	public long getLongNumberFromConsole()
			throws IOException {
		do {
			String s = reader.readLine();
			try {
				return Long.parseLong(s);	
			} catch (NumberFormatException e) {
				System.out.println("Write a number!");
				continue;
			}
		} while (true);
		
	}
	public String getStringFromConsole() throws IOException {
		return reader.readLine();
	}

	public void closeReader() throws IOException {
		reader.close();
	}
}
