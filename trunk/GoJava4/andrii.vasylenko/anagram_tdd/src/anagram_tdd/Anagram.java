package anagram_tdd;

import anagram_tdd.reverse.Reverser;

public class Anagram {

	private String line;
	private Reverser reverser;

	public Anagram(String line, Reverser reverser) throws IllegalArgumentException {
		this.line = line;
		this.reverser = reverser;
		if (!checkInitialization()) {
			throw new IllegalArgumentException();
		}
	}

	public String getAnagram() {
		return reverser.reverseLine(line);
	}

	private boolean checkInitialization() {
		if (line == null) {
			return false;
		}
		if (reverser == null) {
			return false;
		}
		return true;
	}

}
