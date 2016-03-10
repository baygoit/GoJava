package com.goit.module1.humeniuk;

public class AnagramBuilder {
	
	public static final String SPACE = " "; 

	private String anagramWord(String word) {
		char[] letters = word.toCharArray();
		int counter = letters.length - 1;
		for (int index = 0; index < letters.length / 2; index++) {
			char tmp = letters[index];
			letters[index] = letters[counter];
			letters[counter--] = tmp;
		}
		return new String(letters);
	}

	public String buildAnagram(String message) throws NullPointerException {
		String[] splitString = message.split(SPACE);
		String anagram = "";
		for (int index = 0; index < splitString.length; index++) {
			splitString[index] = anagramWord(splitString[index]);
			if (index == splitString.length - 1) {
				anagram += splitString[index];
			} else {
				anagram += splitString[index] + SPACE;
			}
		}
		return anagram;
	}
}
