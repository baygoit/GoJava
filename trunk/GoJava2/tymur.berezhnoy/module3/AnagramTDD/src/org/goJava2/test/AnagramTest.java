package org.goJava2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.goJava2.anagram.Anagram;
import org.junit.Test;

public class AnagramTest {
	
	private Anagram anagram = new Anagram();
	
	public void test(String descript, String expected, String actual) {
		actual = anagram.getReversedSent(actual);
		assertEquals(descript, expected, actual);
	}
	
	@Test(expected = NullPointerException.class)
	public void testExeptions() {		
		test("should be NPE", null, null);
	}
	
	@Test
	public void shouldGetReveresedSentence() {
		test("Return: empty, when param is empty", "", "");
		test("Return: a, when param is: a", "a", "a");
		test("Return: yx, when param is xy", "yx", "xy");
		test("Return: yx!, when param is xy!", "yx!", "xy!");
		test("Return: yx zx, when param is xy xz", "yx zx", "xy xz");
		test("Return: yx! ax@, when param is xy! xa@", "yx! ax@", "xy! xa@");
	}
	
	@Test
	public void shouldNotBeNull() {
		assertNotNull(anagram.enterSent());
	}
}