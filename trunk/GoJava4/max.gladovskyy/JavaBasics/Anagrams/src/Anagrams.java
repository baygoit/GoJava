import java.util.Scanner;
import java.util.regex.Pattern;


public class Anagrams {

	public static void main(String[] args) {
		System.out.println("Enter words divided by spaces and press enter to make anagrams");
		Scanner reader = new Scanner(System.in);
		String userString = reader.nextLine();
		System.out.println(makeAnagrams(userString));
	}

	private static String makeAnagrams(String userString) {
		String[] userStringSplited = userString.split(" ");
		StringBuilder result = new StringBuilder();
		Pattern nonAlphabetPattern = Pattern.compile("[^a-zA-Zà-ÿÀ-ÿ]");
		
		for (String word: userStringSplited) {
			if(nonAlphabetPattern.matcher(word).find()) {
				System.err.println("Entered words contains not alphabetic characters.");
				System.exit(0);
			}
			result.append(new StringBuilder(word).reverse().toString() + " ");
		}
		return result.toString();
	}

}