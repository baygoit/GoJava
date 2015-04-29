import java.io.PrintStream;
import java.util.Scanner;

public class Anagrams {

	private static final String EXIT = "-1";

	public static void main(String[] args) {

		PrintStream out = System.out;
		Scanner in = new Scanner(System.in);

		out.println("To exit type '" + EXIT + "'");

		while (true) {
			out.print("Please type your phrase:");
			String inputPhrase = in.nextLine();

			if (inputPhrase.equalsIgnoreCase(EXIT))
				System.exit(0);

			String[] inputPhraseTokens = inputPhrase.split(" ");
			StringBuilder outputPhrase = new StringBuilder();
			for (String token : inputPhraseTokens) {
				char[] chars = token.toCharArray();
				int tokenLength = chars.length;
				for (int i = 1; i <= tokenLength; i++) {
					outputPhrase.append(chars[tokenLength - i]);
				}
				outputPhrase.append(" ");
			}
			out.println(outputPhrase.toString());
		}
	}

}
