package anagram_tdd;

import anagram_tdd.reverse.Reverser;
import anagram_tdd.reverse.WordsReverser;

public class Anagram {

	private String line;
	private Reverser reverser;

	public Anagram(String line) throws IllegalArgumentException {
		if (!checkInputLine(line)) {
			throw new IllegalArgumentException();
		}
		this.line = line;
		this.reverser = new WordsReverser();
	}

	public String getAnagram() {
		return reverser.reverseLine(line);
	}

	private boolean checkInputLine(String line) {
		return line != null;
	}

}
