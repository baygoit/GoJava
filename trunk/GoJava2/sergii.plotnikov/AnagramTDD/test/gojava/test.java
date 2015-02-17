package gojava;
import static org.junit.Assert.*;

import org.junit.Test;


public class test {

	@Test
	public void shouldReturnSymbol_whenSymbolIsSent() {
		Anagram anagram = new Anagram();
				
		assertEquals("x", anagram.run("x"));
	}

}
