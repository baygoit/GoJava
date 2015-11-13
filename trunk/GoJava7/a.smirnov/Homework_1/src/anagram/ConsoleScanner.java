package anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleScanner {
	
	public String getUserInputString(ConsolePrinter consolePrinter) {
		String result = null;
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			consolePrinter.print("Please enter string : ");
			result = in.readLine();
		} catch (IOException e) {
			System.out.println("Problems with the stream...");
		}
		return result;
	}
}
