import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Anagrams {

	public static void main(String[] args) {
		String userString = readLine();
		System.out.println(reversString(userString));
	}

	private static String reversString(String userString) {
		String[] userStringSplited = userString.split(" ");
		String result = new String();
		
		for (String word: userStringSplited) {
			result = result + reverseWord(word) + " ";
		}
		return result;
	}
	
	private static String readLine() {
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = consoleReader.readLine();
			checkIfEmpty(line);
			return line;
		} catch (IOException e) {
			System.err.println("You entered incorrect data (words separated with space is needed)");
		}
		return null;
	}

	private static void checkIfEmpty(String line) {
		if (line.equals("")) {
			System.err.println("Cant revert empty string");	
			System.exit(0);
		}
	}

	private static String reverseWord(String word) {
		char[] wordLetters = word.toCharArray();
		char[] result = new char[wordLetters.length];
		
		for (int i=0; i<wordLetters.length; i++) {
			result[wordLetters.length-1-i] = filterNotLetters(wordLetters[i]);
		}
		return new String(result);
	}
	
	private static Character filterNotLetters (Character letter) {
		if (!Character.isLetter(letter)) {
			System.err.println(letter + " is not a letter symbol in your string. "
					+ "Please enter string with only letters and spaces");
			System.exit(0);
		}
		return letter;
	}

}