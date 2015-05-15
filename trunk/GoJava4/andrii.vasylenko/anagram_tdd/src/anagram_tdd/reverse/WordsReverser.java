package anagram_tdd.reverse;

public class WordsReverser implements Reverser {

	@Override
	public String reverseLine(String line) {
		String words[] = getWords(line);
		return reverseWords(words);
	}

	@Override
	public boolean checkLine(String line) {
		return line.matches("([A-Za-z0-9 ]*)");
	}

	private String[] getWords(String line) {
		return line.trim().split(" ");
	}

	private String reverseWords(String words[]) {
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
