package goit.nz.lesson1.anagram;

import goit.nz.lesson1.Parser;

public class Anagram {
	private final String SPACE = " ";
	private String[] words;
	private String original;
	private StringBuilder result;
	private Parser parser;

	public Anagram(String toAnagram) {
		parser = new Parser();
		original = toAnagram;
		result = new StringBuilder();
	}

	public void showAnagram() {
		getWords();
		if (words != null) {
			for (String word : words) {
				StringBuilder currentWord = new StringBuilder(word);
				result.append(currentWord.reverse().append(SPACE));
			}
		}
		show();
	}

	private void getWords() {
		if (!original.isEmpty()) {
			words = parser.stringToWords(original);
		} else {
			words = null;
		}
	}

	private void show() {
		System.out.println("Result:");
		System.out.println(result.toString().trim());
	}
}
