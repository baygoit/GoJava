package goit.nz.lesson1.anagram;

import goit.nz.lesson1.Reader;

public class Main {
	public static void main(String[] args) {
		Reader console = new Reader("Please input words separated by spaces:");
		do {
			Anagram anagram = new Anagram(console.readLine());
			anagram.showAnagram();
		} while (console.askForRepeat());
	}
}
