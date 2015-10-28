package ua.com.goit.iegorovDmitri.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Anagram {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new
		InputStreamReader(System.in));
		String inputString = reader.readLine();
		String outputString = "";
		Boolean check = null;
		String stringWhioutSpecial = inputString.replaceAll("[^a-zA-Zà-ÿÀ-ß']", " ").replaceAll(
				" +", " ");
		if (stringWhioutSpecial.charAt(0) == ' ') {
			stringWhioutSpecial = stringWhioutSpecial.substring(1);
			check = true;
		}
		String[] words = stringWhioutSpecial.split("[^a-zA-Zà-ÿÀ-ß']");
		String punctuation = inputString.replaceAll("\\s", "\u0001");
		punctuation = (punctuation.replaceAll("[a-zA-Zà-ÿÀ-ß]", " "))
				.replaceAll(" +", " ");
		if (punctuation.charAt(0) == ' ') {
			punctuation = punctuation.substring(1);
			check = false;
		}
		String[] specChar = punctuation.split(" ");
		
			for (int i = 0; i < Math.min(words.length, specChar.length); i++) {
				StringBuilder builder = new StringBuilder(words[i]);
				if (check != true) {
					outputString += builder.reverse().toString() + specChar[i];
					if (words.length > specChar.length){
						builder = new StringBuilder(words[i+1]);
						outputString +=builder.reverse().toString();
					}
				} else {
					outputString += specChar[i] + builder.reverse().toString();
					if (words.length > specChar.length){
						outputString +=specChar[i+1];
					}
				}
			}

		System.out.println(outputString.replaceAll("\u0001", " "));

	}

}
