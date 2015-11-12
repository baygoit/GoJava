package ua.com.goit.gojava7.kickstarter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
	private BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));

	public int getNumberFromConsole()
			throws NumberFormatException, IOException {
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

	public void closeReader() throws IOException {
		reader.close();
	}
}
