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
		String words[] = line.trim().split(" ");
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			result.append(reverseWord(words[i]));
			result.append(" ");
		}
		return result.toString().trim();
	}
	
	private String reverseWord(String word) {
		StringBuilder result = new StringBuilder(word);
		result.reverse();
		return result.toString();		
	}

}
