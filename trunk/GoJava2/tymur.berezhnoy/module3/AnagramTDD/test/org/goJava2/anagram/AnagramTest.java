package org.goJava2.anagram;

import static org.junit.Assert.*;

import org.goJava2.anagram.Anagram;
import org.junit.Test;

public class AnagramTest {
	
	private Anagram anagram = new Anagram();
	
	public void test(String expected, String actual) {
		actual = anagram.getReversedSent(actual);
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldBe_Empty_WhenParamIs_Empty() {
		test("", "");
	}
	
	@Test
	public void shouldBe_Space_WhenParamIs_Space() {
		test(" ", " ");
	}
	
	@Test
	public void shouldBe_OneSymbol_WhenParamIs_OneSymbol() {
		test("x", "x");
	}
	
	@Test
	public void souldBe_Reversed_WhenPramIs_XY() {
		test("yx", "xy");
	}
	
	@Test
	public void shouldBe_Reversed_WhenParamIs_BySpace() {
		test("yx yx", "xy xy");
	}
	
	@Test
	public void souldBe_SamePlace_WhenParamIs_Symbol() {
		test("xy!", "yx!");
	}
	
	@Test
	public void shouldBe_Reversed_WhenParamIs_longSent() {
		test("olleH dlrow! woH era uoy?", "Hello world! How are you?");
	}
	
	@Test
	public void shouldBe_SamePosition_WhenParamIs_SpecificSymbol() {
		test(anagram.getDelimiters(), anagram.getDelimiters());
	}
	
	@Test
	public void exceptionsTest() {
		assertEquals("", anagram.getReversedSent(null));
	}
}