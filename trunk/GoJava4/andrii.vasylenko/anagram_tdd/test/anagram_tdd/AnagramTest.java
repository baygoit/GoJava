package anagram_tdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramTest {

	@Test
	public void shouldEmptyString_whenEmptyString() {
		assertEquals("", new Anagram("").getAnagram());
	}

}
