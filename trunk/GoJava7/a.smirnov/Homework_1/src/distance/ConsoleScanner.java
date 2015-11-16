package distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleScanner {
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public String getUserInputString() {
		String result = null;
		try {
			System.out.println("Please ented integer numbers separated by spaces : ");
			result = in.readLine();
		} catch (IOException e) {
			System.out.println("Problems with the stream...");
		}
		return result;
	}

	public List<Integer> parseInt(String inputedString) {
		List<Integer> inputedNumbers = new ArrayList<>();
		String[] arrayOfStrings = inputedString.split(" ");
		for (String str : arrayOfStrings) {
			int number = Integer.parseInt(str);
			inputedNumbers.add(number);
		}
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
