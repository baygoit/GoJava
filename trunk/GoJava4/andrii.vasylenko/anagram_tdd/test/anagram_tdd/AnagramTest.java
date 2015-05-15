package anagram_tdd;

import static org.junit.Assert.*;

import org.junit.Test;

import anagram_tdd.reverse.WordsReverser;

public class AnagramTest {

	@Test
	public void shouldEmptyString_whenEmptyString() {
		assertAnagram("", "");
	}

	@Test
	public void shouldEmptyString_whenSpace() {
		assertAnagram("", " ");
	}

	@Test
	public void shouldLetter_whenLetter() {
		assertAnagram("a", "a");
	}

	@Test
	public void shouldDigit_whenDigit() {
		assertAnagram("1", "1");
	}

	@Test
	public void shouldReverseLetters_whenTwoLetters() {
		assertAnagram("ba", "ab");
	}

	@Test
	public void shouldReverseDigits_whenTwoDigits() {
		assertAnagram("21", "12");
	}

	@Test
	public void shouldReverseWord_whenWord() {
		assertAnagram("drow", "word");
	}

	@Test
	public void shouldReverseNumber_whenNumber() {
		assertAnagram("654321", "123456");
	}

	@Test
	public void shouldReverseEachWord_whenSentence() {
		assertAnagram("marganA esrever hcae drow", "Anagram reverse each word");
	}

	@Test
	public void shouldReverseEachNumber_whenNumbers() {
		assertAnagram("321 654 987", "123 456 789");
	}

	@Test
	public void shouldReverseEachWordOrNumber_whenSentenceWithNumbers() {
		assertAnagram("marganA esrever hcae drow 321", "Anagram reverse each word 123");
	}

	@Test
	public void shouldIgnoreFirstAndLastSpaces_whenSentenceWithFirstOrLastSpaces() {
		assertAnagram("marganA esrever hcae drow 321", " Anagram reverse each word 123 ");
		assertAnagram("marganA esrever hcae drow 321", " Anagram reverse each word 123");
		assertAnagram("marganA esrever hcae drow 321", "Anagram reverse each word 123 ");
	}

	@Test
	public void shouldSentenceWithDoubleSpaces_whenSentenceWithDoubleSpaces() {
		assertAnagram("marganA  esrever  hcae drow  321", "Anagram  reverse  each word  123");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldException_whenNullLine() {
		new Anagram(null, new WordsReverser()).getAnagram();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldException_whenNullReverser() {
		new Anagram("", null).getAnagram();
	}
	
	private void assertAnagram(String expected, String inputLine) {
		assertEquals(expected, new Anagram(inputLine, new WordsReverser()).getAnagram());
	}

}
