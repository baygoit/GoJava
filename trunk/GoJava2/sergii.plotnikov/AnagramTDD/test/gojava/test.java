package gojava;
import static org.junit.Assert.*;

import org.junit.Test;


public class test {

	@Test
	public void shouldReturnSymbol_whenSymbolIsSent() {
		Assert("x", "x");
	}
	
	@Test
	public void shouldReturnReversedLine_whenStringIsSent() {
		Assert("zyx", "xyz");
	}
	
	@Test
	public void shouldReturnAnagram_whenStringIsSent() {
		Assert("cba zyx gfe", "abc xyz efg");
	}
	
	@Test
	public void shouldLeaveCommas_whenStringIsSent() {
		Assert("cba, zyx", "abc, xyz");
	}
	
	@Test
	public void shouldLeaveSpecialSigns_whenStringIsSent() {
		Assert("cba, zyx?!", "abc, xyz?!");
	}
	
	@Test
	public void shouldChangeToUpperFirstLetter_whenStringIsSent() {
		Assert("Cba, zyx?!", "Abc, xyz?!");
	}
	
	public void Assert(String expected, String toSend){
		Anagram anagram = new Anagram();
		assertEquals(expected, anagram.run(toSend));
	}

}
