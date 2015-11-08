package homework1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReverse {
	private static final String PATTERN = "[A-zÀ-ÿ,¸¨]+";

	public static void main(String[] args) {

		new StringReverse().print();
	}

	public void print() {
		StringBuilder result = new StringBuilder();
		String userInputedString = getUserInputedString();
		String reversedString = reverseInputedString(userInputedString);
		result.append("User's inputed string: ").
			append(userInputedString).
			append("\n").
			append("Reversed string: ").
			append(reversedString);
		System.out.println(result.toString());
	}

	private String getUserInputedString() {
		System.out.println("Please enter string: ");
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}

	private String reverseInputedString(String userInputedString) {
		StringBuilder result = new StringBuilder(userInputedString);
		Matcher metcher = Pattern.compile(PATTERN).matcher(userInputedString);

		while (metcher.find()) {
			result.replace(
					metcher.start(), 
					metcher.end(), 
					new StringBuilder(metcher.group()).reverse().toString());
		}
		return result.toString();
	}
}
