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
		this.original = toAnagram;
		result = new StringBuilder();
	}
	
	public void showAnagram() {
		this.getWords();
		if (this.words != null) {
			for (int i = 0; i < this.words.length; i++) {
				StringBuilder word = new StringBuilder(this.words[i]);
				this.result.append(word.reverse() + this.SPACE);
			}
		}
		this.show();
	}
	 
	private void getWords() {
		if (!this.original.isEmpty()) {
			words = parser.stringToWords(this.original);
		} else {
			words = null;
		}
	}
	
	private void show() {
		System.out.println("Result:");
		System.out.println(this.result.toString().trim());
	}
}
