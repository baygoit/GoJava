package ua.com.goit.gojava7.kickstarter.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleScanner {
	static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
	
	public static int getInt() throws IOException {
		String input = READER.readLine();
		int inputInt = Integer.parseInt(input);
		return inputInt;
	}
}
