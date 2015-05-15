package anagram_tdd;

public class Anagram {
	
	private String line;

	public Anagram(String line) {
		if (line == null) {
			throw new IllegalArgumentException();
		}
		this.line = line.trim();
	}

	public String getAnagram() {
		StringBuilder result = new StringBuilder(line);
		result.reverse();
		return result.toString();
	}

}
