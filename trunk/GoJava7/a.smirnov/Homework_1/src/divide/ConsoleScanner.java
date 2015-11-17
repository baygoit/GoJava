package divide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleScanner {
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public String getFirstUserNumber() {
		String inputedNumber = null;
		try {
			System.out.println("Please ented first number : ");
			inputedNumber = in.readLine();
		} catch (IOException e) {
			System.out.println("Problems with the stream...");
		}
		return inputedNumber;
	}
	
	public String getSecondUserNumber() {
		String inputedNumber = null;
		try {
			System.out.println("Please ented second number : ");
			inputedNumber = in.readLine();
		} catch (IOException e) {
			System.out.println("Problems with the stream...");
		}
		return inputedNumber;
	}


	public int parseInt(String inputedString) {
		int inputedNumbers = Integer.parseInt(inputedString);
		return inputedNumbers;
	}
	
	public void shutDown() {
		try {
			in.close();
		} catch (IOException e) {
			System.out.println("Problems with closing stream...");
		}
	}
}
