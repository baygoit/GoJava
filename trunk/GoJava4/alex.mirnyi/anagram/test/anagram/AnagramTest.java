package anagram;

import static org.junit.Assert.*;
import org.junit.Test;

import anagram;

public class AnagramTest {
	
	@Test
	public void shouldEmptyString_whenEmptyString() {
		assertAnagramUsedWordsReverser("", );
	}

}
