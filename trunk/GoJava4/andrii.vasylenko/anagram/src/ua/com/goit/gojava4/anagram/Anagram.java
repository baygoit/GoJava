package ua.com.goit.gojava4.anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
	public static final String SEPARATOR = " ";
	private String lineOfWords;

	public Anagram(String lineOfWords) {
		this.lineOfWords = lineOfWords;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Input words:");
		String line = reader.readLine();
		System.out.println(new Anagram(line).getAnagramLine());
		reader.close();
	}

	public String getAnagramLine() {
		String[] words = lineOfWords.split(SEPARATOR);
		reverse(words);
		return composeLine(words);
	}

	private String composeLine(String[] words) {
		StringBuilder result = new StringBuilder();
		for (String word : words) {
			result.append(word);
			result.append(SEPARATOR);
		}
		return result.toString().trim();
	}

	private void reverse(String[] words) {
		for (int index = 0; index < words.length; index++) {
			String word = words[index];
			words[index] = reverse(word);
		}
	}

	private String reverse(String word) {
		return new StringBuilder(word).reverse().toString();
	}
}
