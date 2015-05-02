import java.util.Scanner;
import java.util.regex.Pattern;


public class Anagrams {

	public static void main(String[] args) {
		System.out.println("Enter words divided by spaces and press enter to make anagrams");
		System.out.println(makeAnagrams(new Scanner(System.in).nextLine()));
	}

	private static String makeAnagrams(String userString) {
		StringBuilder result = new StringBuilder();
		Pattern nonAlphabet = Pattern.compile("[^a-zA-Z]");
		
		for (String word: userString.split(" ")) {
			if(nonAlphabet.matcher(word).find()) {
				System.err.println("Entered words contains not alphabetic characters.");
				System.exit(0);
			}
			result.append(new StringBuilder(word).reverse().toString() + " ");
		}
		return result.toString();
	}

}