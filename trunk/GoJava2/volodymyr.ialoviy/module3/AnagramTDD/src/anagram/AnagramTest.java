package anagram;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AnagramTest {
	
	@Test
    public void sholdEpty_whenEmpty(){
		assertEquals("", Anagram.anagram(""));
	}
	
	@Test
    public void sholdSingleCharacter_whenSingleCharacter(){
		assertEquals("x", Anagram.anagram("x"));
	}
	
	@Test
    public void sholdWord_whenWordBackwards(){
		assertEquals("xyy", Anagram.anagram("yyx"));
	}
	
	@Test
    public void sholdTwoWord_whenTwoWordBackwards(){
		assertEquals("xyy rt", Anagram.anagram("yyx tr"));
	}
}