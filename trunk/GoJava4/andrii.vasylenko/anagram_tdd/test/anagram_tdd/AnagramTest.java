package anagram_tdd;

import static org.junit.Assert.*;

import org.junit.Test;

import anagram_tdd.reverse.Reverser;
import anagram_tdd.reverse.WordsReverser;

public class AnagramTest {

	@Test
	public void shouldEmptyString_whenEmptyString() {
		assertAnagramUsedWordsReverser("", "");
	}

	@Test
	public void shouldEmptyString_whenSpace() {
		assertAnagramUsedWordsReverser("", " ");
	}

	@Test
	public void shouldLetter_whenLetter() {
		assertAnagramUsedWordsReverser("a", "a");
	}

	@Test
	public void shouldDigit_whenDigit() {
		assertAnagramUsedWordsReverser("1", "1");
	}

	@Test
	public void shouldReverseLetters_whenTwoLetters() {
		assertAnagramUsedWordsReverser("ba", "ab");
	}

	@Test
	public void shouldReverseDigits_whenTwoDigits() {
		assertAnagramUsedWordsReverser("21", "12");
	}

	@Test
	public void shouldReverseWord_whenWord() {
		assertAnagramUsedWordsReverser("drow", "word");
	}

	@Test
	public void shouldReverseNumber_whenNumber() {
		assertAnagramUsedWordsReverser("654321", "123456");
	}

	@Test
	public void shouldReverseEachWord_whenSentence() {
		assertAnagramUsedWordsReverser("marganA esrever hcae drow", "Anagram reverse each word");
	}

	@Test
	public void shouldReverseEachNumber_whenNumbers() {
		assertAnagramUsedWordsReverser("321 654 987", "123 456 789");
	}

	@Test
	public void shouldReverseEachWordOrNumber_whenSentenceWithNumbers() {
		assertAnagramUsedWordsReverser("marganA esrever hcae drow 321", "Anagram reverse each word 123");
	}

	@Test
	public void shouldIgnoreFirstAndLastSpaces_whenSentenceWithFirstOrLastSpaces() {
		assertAnagramUsedWordsReverser("marganA esrever hcae drow 321", " Anagram reverse each word 123 ");
		assertAnagramUsedWordsReverser("marganA esrever hcae drow 321", " Anagram reverse each word 123");
		assertAnagramUsedWordsReverser("marganA esrever hcae drow 321", "Anagram reverse each word 123 ");
	}

	@Test
	public void shouldSentenceWithDoubleSpaces_whenSentenceWithDoubleSpaces() {
		assertAnagramUsedWordsReverser("marganA  esrever  hcae drow  321", "Anagram  reverse  each word  123");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldException_whenNullLine() {
		new Anagram(null, new WordsReverser()).getAnagram();
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldException_whenNullReverser() {
		new Anagram("", null).getAnagram();
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldException_whenLine—ontainsNotAllowSymbols() {
		new Anagram("marganA!  esrever&  hcae? drow)  ,321", new WordsReverser()).getAnagram();
	}

	private void assertAnagramUsedWordsReverser(String expected, String inputLine) {
		assertAnagram(expected, inputLine, new WordsReverser());
	}

	private void assertAnagram(String expected, String inputLine, Reverser reverser) {
		assertEquals(expected, new Anagram(inputLine, reverser).getAnagram());
	}

}
