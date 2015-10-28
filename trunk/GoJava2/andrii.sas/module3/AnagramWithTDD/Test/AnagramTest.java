import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramTest {
	Anagram anagram = new Anagram();

	public void test(String expect, String actual) {
		actual = anagram.getAnagram(actual);
		assertEquals(expect, actual);
	}

	@Test
	public void shouldReturnEmpty_whenEmptyIsSended() {
		test("", "");
	}

	@Test
	public void shouldReturnString_whenStringIsSended() {
		test("x", "x");
	}

	@Test
	public void shouldReverceWord_whenItReturned() {
		test("yx", "xy");
	}

	@Test
	public void shouldReteinSpace_whenCharReverced() {
		test("x y", "x y");
	}
	
	@Test
	public void shouldReteinSpace_whenWordsReverced() {
		test("xy ab", "yx ba");
	}
}
