package anagram;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anagram {
	private static final String PATTERN = "[A-zÀ-ÿ,¸¨]+";

	public String reverseString(String inputedString) {
		StringBuilder result = new StringBuilder(inputedString);
		Matcher metcher = Pattern.compile(PATTERN).matcher(inputedString);

		while (metcher.find()) {
			result.replace(
					metcher.start(), 
					metcher.end(), 
					new StringBuilder(metcher.group()).reverse().toString());
		}
		return result.toString();
	}
}
