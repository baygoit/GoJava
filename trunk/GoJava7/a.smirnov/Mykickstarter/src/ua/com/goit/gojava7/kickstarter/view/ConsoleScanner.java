package ua.com.goit.gojava7.kickstarter.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleScanner {
	private static final String PROBLEMS = "Problems with stream...";
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public int getInt() {
		int userNumber = Integer.MAX_VALUE;
		
		try {
			String inputedUserString = bufferedReader.readLine();
			userNumber = Integer.parseInt(inputedUserString);
		} catch (NumberFormatException | IOException e) {
			System.out.print("You entered forbidden symbol. ");
		}
		return userNumber;
	}

	public String getString() {
		String name = null;
		
		try {
			name = bufferedReader.readLine();
		} catch (IOException e) {
			System.out.println(PROBLEMS);
		}
		return name;
	}

	public void close() {
		try {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		} catch (IOException e) {
			System.out.println(PROBLEMS);
		}
	}

}
