package ua.com.goit.gojava7.kickstarter.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static int getUserChoice() throws IOException {
		String userChoise = reader.readLine();
		int userChoiseInt = Integer.parseInt(userChoise);
		return userChoiseInt;
	}
	
	public String getString() throws IOException {
		String input = reader.readLine();
		return input;
	}
	
	public long getLongInput() throws IOException {
		String input = reader.readLine();
		long longInput = Long.parseLong(input);
		return longInput;
	}
	
	public void close() throws IOException {
		reader.close();
	}
}
