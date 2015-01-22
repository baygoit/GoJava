package ua.com.goit.iegorovDmitri.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Anagram {
	public static void main(String[] args) throws IOException {
		// BufferedReader reader = new BufferedReader(new
		// InputStreamReader(System.in));
		// String inputString = reader.readLine();
		String inputString = "gena+++gean---  gean  fre==";
		String outputString = "";
		Boolean check = null;
		String s = inputString.replaceAll("[^a-zA-Zà-ÿÀ-ß']", " ").replaceAll(
				" +", " ");
		if (s.charAt(0) == ' ') {
			s = s.substring(1);
			check = true;
		}
		System.out.println(s);
		String[] words = s.split("[^a-zA-Zà-ÿÀ-ß']");
		String punctuation = inputString.replaceAll("\\s", "\u0001");
		punctuation = (punctuation.replaceAll("[a-zA-Zà-ÿÀ-ß]", " "))
				.replaceAll(" +", " ");
		if (punctuation.charAt(0) == ' ') {
			punctuation = punctuation.substring(1);
			check = false;
		}
		System.out.println(punctuation);
		String[] specChar = punctuation.split(" ");
		System.out.println(words.length + " " + specChar.length);

		for (int i = 0; i < words.length; i++) {
			StringBuilder builder = new StringBuilder(words[i]);
			if (check != true) {
				outputString+=builder.reverse().toString() + specChar[i];
			} else {
				outputString += specChar[i] + builder.reverse().toString();
			}
		}

		System.out.println(outputString.replaceAll("\u0001", " "));

	}

}
