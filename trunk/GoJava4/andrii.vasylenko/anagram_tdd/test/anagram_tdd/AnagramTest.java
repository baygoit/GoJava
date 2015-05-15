package anagram_tdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramTest {

	@Test
	public void shouldEmptyString_whenEmptyString() {
		assertEquals("", new Anagram("").getAnagram());
	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldException_whenNull() {
		assertNotEquals("", new Anagram(null).getAnagram());
	}

	@Test
	public void shouldEmptyString_whenSpace() {
		assertEquals("", new Anagram(" ").getAnagram());
	}

	@Test
	public void shouldLetter_whenLetter() {
		assertEquals("a", new Anagram("a").getAnagram());
	}

	@Test
	public void shouldDigit_whenDigit() {
		assertEquals("1", new Anagram("1").getAnagram());
	}

	@Test
	public void shouldReverseLetters_whenTwoLetters() {
		assertEquals("ba", new Anagram("ab").getAnagram());
	}

	@Test
	public void shouldReverseDigits_whenTwoDigits() {
		assertEquals("21", new Anagram("12").getAnagram());
	}

	@Test
	public void shouldReverseWord_whenWord() {
		assertEquals("drow", new Anagram("word").getAnagram());
	}

	@Test
	public void shouldReverseNumber_whenNumber() {
		assertEquals("654321", new Anagram("123456").getAnagram());
	}

	@Test
	public void shouldReverseEachWord_whenSentence() {
		assertEquals("marganA esrever hcae drow", new Anagram("Anagram reverse each word").getAnagram());
	}

}
