import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Anagrams {

	public static void main(String[] args) throws IOException {
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		String userString = consoleReader.readLine();
		String[] userStringSplited = userString.split(" ");
		
		for (String word: userStringSplited) {
			System.out.print(reverse(word)+" ");
		}
		
	}

	private static String reverse(String word) {
		char[] wordChars = word.toCharArray();
		char[] result = new char[wordChars.length];
		
		for (int i=0; i<wordChars.length; i++) {
			result[wordChars.length-1-i] = wordChars[i];
		}
		return new String(result);
	}

}
