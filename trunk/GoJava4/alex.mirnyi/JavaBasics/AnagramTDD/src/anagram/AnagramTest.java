package anagram;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramTest {
	
	@Test
	public void shouldEmptyString_whenEmptyString() {
		String input = "";
		
		Reverse reversedWord= new Reverse(input);
		String output = reversedWord.change();
		
		assertEquals("", output);
	}
	
	@Test
	public void shouldEmptyString_whenSpace() {
		String input = " ";
		
		Reverse reversedWord= new Reverse(input);
		String output = reversedWord.change();
		
		assertEquals("", output);
	}
	
	@Test
	public void shouldOneLetter_whenOneLetter() {
		String input = "a";
		
		Reverse reversedWord= new Reverse(input);
		String output = reversedWord.change();
		
		assertEquals("a", output);
	}
	
	@Test
	public void shouldOneDigit_whenOneDigit() {
		String input = "1";
		
		Reverse reversedWord= new Reverse(input);
		String output = reversedWord.change();
		
		assertEquals("1", output);
	}
	
	@Test
	public void shouldTwoReversedLetters_whenTwoLetters() {
		String input = "ab";
		
		Reverse reversedWord= new Reverse(input);
		String output = reversedWord.change();
		
		assertEquals("ba", output);
	}

	@Test
	public void shouldTwoReversedDigits_whenTwoDigits() {
		String input = "12";
		
		Reverse reversedWord= new Reverse(input);
		String output = reversedWord.change();
		
		assertEquals("21", output);
	}
	
	@Test
	public void shouldReversedWord_whenWord() {
		String input = "word";
		
		Reverse reversedWord= new Reverse(input);
		String output = reversedWord.change();
		
		assertEquals("drow", output);
	}
	
	@Test
	public void shouldTwoReversedWords_whenTwoWords() {
		String input = "two word";
		
		Reverse reversedWord= new Reverse(input);
		String output = reversedWord.change();
		
		assertEquals("owt drow", output);
	}
	
	@Test
	public void shouldTrimSpaces_whenWords() {
		String input = " ol  low  ";
		
		Reverse reversedWord= new Reverse(input);
		String output = reversedWord.change();
		
		assertEquals("lo  wol", output);
	}
}