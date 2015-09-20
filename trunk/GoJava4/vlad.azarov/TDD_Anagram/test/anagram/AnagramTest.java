package anagram;

import org.junit.Test;

public class AnagramTest {

    Anagram anagram = new Anagram();

    @Test
    public void readInput() {
	anagram.readInput();
    }

    @Test
    public void getInput() {
	anagram.getInput();
    }

    @Test
    public void makeAnagramFrom() {
	anagram.makeAnagramFrom("some text");
    }
    
    @Test
    public void printResult() {
	anagram.printResult();
    }
}
