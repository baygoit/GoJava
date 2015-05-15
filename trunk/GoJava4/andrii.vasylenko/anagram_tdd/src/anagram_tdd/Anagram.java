package anagram_tdd;

public class Anagram {
	
	private String line;

	public Anagram(String line) {
		if (line == null) {
			throw new IllegalArgumentException();
		}
		this.line = line;
	}

	public String getAnagram() {
		return line;
	}

}
