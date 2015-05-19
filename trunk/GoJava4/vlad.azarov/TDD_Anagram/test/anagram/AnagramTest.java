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
    public void makeAnagram() {
	anagram.makeAnagramFrom("Hello");
    }
    
    @Test
    public void printResult() {
	anagram.printResult();
	System.out.println();
    }
}
