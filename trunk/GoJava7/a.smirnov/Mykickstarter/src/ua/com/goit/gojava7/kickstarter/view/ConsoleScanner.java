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
	
	public long getLong() {
		long userNumber = Long.MAX_VALUE;
		
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

	public int parseDonatingAmount() {
		int donatingAmount = -1;
		do {
			System.out.println("Please enter donating sum : ");
			donatingAmount = getInt();
		} while (donatingAmount < 0);
		
		return donatingAmount;
	}
	
	public long parseCreditCardNumber() {
		long creditCardNumber = -1;
		do {
			System.out.println("Please enter you card number : ");
			creditCardNumber = getLong();
		} while (creditCardNumber < 0);
		
		return creditCardNumber;
	}
	
	public String parseUserName() {
		System.out.println("Please enter you name :");
		String userName = getString();
		return userName;
	}
	
	public String parseAskingQuestion() {
		System.out.println("Please enter your question : ");
		String question = getString();
		return question;
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
