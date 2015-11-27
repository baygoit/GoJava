package go.it.test;

import static org.junit.Assert.assertEquals;
import go.it.main.WordsReverse;
import go.it.salivon.ReverseString;

import org.junit.BeforeClass;
import org.junit.Test;

public class WordsReversTest {

	private static WordsReverse util;

	@BeforeClass
	public static void setUp() throws Exception {
		util = new ReverseString();
	}

	@Test
	public void testEmptyString() {
		String phrase = "";
		String result = util.reverseWords(phrase);
		assertEquals("", result);
	}

	@Test
	public void testGapString() {
		String phrase = " ";
		String result = util.reverseWords(phrase);
		assertEquals(" ", result);
	}

	@Test(expected = NullPointerException.class)
	public void testNullString() {
		util.reverseWords(null);
	}

	@Test
	public void testString() {
		String phrase = "Hi, my name is Jim";
		String result = util.reverseWords(phrase);
		assertEquals(",iH ym eman si miJ", result);
	}

	@Test
	public void testReturnStaticValue() {
		String phrase = "This is words";
		String result = util.reverseWords(phrase);
		assertEquals("sihT si sdrow", result);
	}

}
