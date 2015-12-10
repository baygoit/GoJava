package ua.com.goit.gojava7.kickstarter.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleScanner {
	private static final String PROBLEM_ENTERED_FORBIDDEN_SYMBOL = "You entered forbidden symbol. Please try again";
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public int getInt() {
		int userNumber = Integer.MIN_VALUE;
		do {
			try {
				String inputedUserString = bufferedReader.readLine();
				userNumber = Integer.parseInt(inputedUserString);
			} catch (NumberFormatException | IOException e) {
				System.out.println(PROBLEM_ENTERED_FORBIDDEN_SYMBOL);
			}
		} while (userNumber == Integer.MIN_VALUE);
		
		return userNumber;
	}
	
	public long getLong() {
		long userNumber = Long.MIN_VALUE;
		do {
			try {
				String inputedUserString = bufferedReader.readLine();
				userNumber = Integer.parseInt(inputedUserString);
			} catch (NumberFormatException | IOException e) {
				System.out.println(PROBLEM_ENTERED_FORBIDDEN_SYMBOL);
			}
		} while (userNumber == Long.MIN_VALUE);
		
		return userNumber;
	}

	public String getString() {
		String name = null;
		
		try {
			name = bufferedReader.readLine();
		} catch (IOException e) {
			System.out.println("Problems with stream...");
		}
		return name;
	}

	public int parseDonatingAmount() {
		System.out.println("Please enter donating sum : ");
		int	donatingAmount = getInt();
		return donatingAmount;
	}
	
	public long parseCreditCardNumber() {
		System.out.println("Please enter you card number : ");
		long creditCardNumber = getLong();
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
			System.out.println("Problems with stream closing...");
		}
	}
}
