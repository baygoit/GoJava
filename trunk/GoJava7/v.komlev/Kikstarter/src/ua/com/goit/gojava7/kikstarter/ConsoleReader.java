package ua.com.goit.gojava7.kikstarter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public int getNumberFromConsoel() throws IOException {

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
