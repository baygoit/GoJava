package anagram;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJunit {
    
    String message = "Hello world";
    Anagram anagram = new Anagram();
    
    @Test
    public void testPrintResult() {
	assertEquals(message, anagram.printResult());
    }
}
