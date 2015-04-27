package ua.com.goit.gojava4.anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Input words:");
		String words = reader.readLine();
		System.out.println(new Anagram().getAnagramLine(words));
		reader.close();
	}

	public String getAnagramLine(String words) {
		return getAnagramLine(words.split(" "));
	}
	
	private String getAnagramLine(String[] words) {
		StringBuilder result = new StringBuilder();
		for (String word : words) {
			result.append(reverse(word));
			result.append(" ");
		}
		return result.toString();
	}

	private String reverse(String word) {
		return new StringBuilder(word).reverse().toString();
	}
}
