package anagram_tdd;

import anagram_tdd.reverse.Reverser;

public class Anagram {

	private String line;
	private Reverser reverser;

	public Anagram(String line, Reverser reverser) throws IllegalArgumentException {
		if (!checkInputLine(line)) {
			throw new IllegalArgumentException();
		}
		this.line = line;
		this.reverser = reverser;
	}

	public String getAnagram() {
		return reverser.reverseLine(line);
	}

	private boolean checkInputLine(String line) {
		return line != null;
	}

}
