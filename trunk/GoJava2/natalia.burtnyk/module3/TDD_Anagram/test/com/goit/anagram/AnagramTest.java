package com.goit.anagram;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AnagramTest {
	
	private Anagram anagram;
	
	@Before
	public void setUp() {
		anagram = new Anagram();
	}
	
	private void testSentence(String expected, String actual) {
		assertEquals(expected, anagram.getReversedSentence(actual));
	}
	
	@Test
	public void should_empty_whenNull() {
		testSentence("", null);
	}
	
	@Test
	public void should_empty_whenEmpty() {
		testSentence("", "");
	}
	
	@Test
	public void should_space_whenSpace() {
		testSentence(" ", " ");
	}

	
	@Test
	public void should_symbol_whenSymbol() {
		testSentence("w", "w");
	}
	
	@Test
	public void should_yx_when_xy() {
		testSentence("yx", "xy");
	}
	
	@Test
	public void should_symbolsBySpace_when_symbolsBySpace() {
		testSentence("x y", "x y");
	}
	
	@Test
	public void should_yx_wz_when_zw_xy() {
		testSentence("wz yx", "zw xy");
	}
	
	@Test
	public void should_yxAnySpecialSymbol_when_xyAnySecialSymbol() {
		testSentence("yx^#&^%", "xy^#&^%");
	}
	
	@Test
	public void should_reversedSentence_when_sentenceWitAnySpecialSymbols() {
		testSentence("A rehtom hsaw swodniw, srood dna roolf!", "A mother wash windows, doors and floor!");
	}
}