package anagram_tdd;

import anagram_tdd.reverse.Reverser;

public class Anagram {

	private String line;
	private Reverser reverser;

	public Anagram(String line, Reverser reverser) throws IllegalArgumentException {
		this.line = line;
		this.reverser = reverser;

		checkInitialization();
	}

	public String getAnagram() {
		return reverser.reverseLine(line);
	}

	private void checkInitialization() {
		if (line == null || reverser == null) {
			throw new NullPointerException();
		}
		if (!reverser.checkLine(line)) {
			throw new IllegalArgumentException();
		}
	}

}
