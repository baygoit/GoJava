package ua.dborysenko.anagrams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	private String readString() {
		Scanner scanner = new Scanner(System.in);
		String resultString = scanner.nextLine();
		scanner.close();
		return (resultString);
	}

	private List<String> separateStringToWords(String inputPhrase) {
		List<String> wordsList = new ArrayList<String>();
		String word = "";
		for (int i = 0; i < inputPhrase.length(); i++) {
			if (' ' == inputPhrase.charAt(i)) {
				wordsList.add(word);
				word = "";
			} else {
				word = word + inputPhrase.charAt(i);
			}
		}
		if ("" != word) {
			wordsList.add(word);
		}
		return wordsList;
	}

	private String swapWord(String word) {
		String swappedWord = "";
		for (int i = word.length() - 1; i >= 0; i--) {
			swappedWord = swappedWord + word.charAt(i);
		}
		return swappedWord;
	}

	private List<String> buildSwappedWordsList(String inputPhrase) {
		List<String> wordsList = separateStringToWords(inputPhrase);
		List<String> swappedWordsList = new ArrayList<String>();
		for (String word : wordsList) {
			swappedWordsList.add(swapWord(word));
		}
		return swappedWordsList;
	}

	private String buildSwappedPhrase(List<String> words) {
		String swappedPhrase = "";
		for (String word : words) {
			swappedPhrase = swappedPhrase + " " + word;
		}
		return swappedPhrase.trim();
	}

	public void start() {
		System.out.println("Enter the string:");
		String inputPhrase = this.readString();
		List<String> swappedWordsList = this.buildSwappedWordsList(inputPhrase);
		System.out.println("Handled string:");
		System.out.println(this.buildSwappedPhrase(swappedWordsList));
	}
}
