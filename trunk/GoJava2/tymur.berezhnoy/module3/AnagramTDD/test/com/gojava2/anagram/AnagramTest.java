package com.gojava2.anagram;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.gojava2.anagram.Anagram;

public class AnagramTest {
	
	private Anagram anagram;
	
	@Before
	public void setUp() {
		anagram = new Anagram();
	}
	
	public void test(String expected, String actual) {
		assertEquals(expected, anagram.getReversedSent(actual));
	}
	
	@Test
	public void shouldBe_empty_whenParamIs_empty() {
		test("", "");
	}
	
	@Test
	public void shouldBe_space_whenParamIs_space() {
		test(" ", " ");
	}
	
	@Test
	public void shouldBe_oneSymbol_whenParamIs_oneSymbol() {
		test("x", "x");
	}
	
	@Test
	public void souldBe_reversed_whenPramIs_xy() {
		test("yx", "xy");
	}
	
	@Test
	public void shouldBe_reversed_whenParamIs_bySpace() {
		test("yx yx", "xy xy");
	}
	
	@Test
	public void souldBe_samePlace_whenParamIs_symbol() {
		test("xy!", "yx!");
	}
	
	@Test
	public void shouldBe_reversed_whenParamIs_longSent() {
		test("olleH dlrow! woH era uoy?", "Hello world! How are you?");
	}
	
	@Test
	public void shouldBe_samePosition_whenParamIs_specificSymbol() {
		anagram.setNewDelimiters("^&*");
		test("ab^&*", "ba^&*");
	}
	
	@Test
	public void shouldBe_empty_whenParamIs_null() {
		assertEquals("", anagram.getReversedSent(null));
	}
}