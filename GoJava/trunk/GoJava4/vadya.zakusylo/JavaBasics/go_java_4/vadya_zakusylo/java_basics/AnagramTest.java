package go_java_4.vadya_zakusylo.java_basics;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnagramTest {
	static Anagram anagram;

	@BeforeClass
	public static void oneTimeSetUp() {
		anagram = new Anagram();
	}

	@AfterClass
	public static void oneTimeTearDown() {
		anagram = null;
	}

	@Test
	public void testPermuteSimbolToSimbol() {
		String[] arrayText = { "a" };
		assertEquals("a", anagram.permute(arrayText));
	}

	@Test
	public void testPermuteTwoSimbolToTwoSimbol() {
		String[] arrayText = { "ab" };
		assertEquals("ba", anagram.permute(arrayText));
	}

	@Test
	public void testPermuteWordToWord() {
		String[] arrayText = { "mother" };
		assertEquals("rehtom", anagram.permute(arrayText));
	}

	@Test
	public void testPermuteTwoWordToTwoWord() {
		String[] arrayText = { "Hello", "world" };
		assertEquals("olleH dlrow", anagram.permute(arrayText));
	}

	@Test
	public void testPermuteExpressionToExpression() {
		String[] arrayText = { "Have", "a", "nice", "day!" };
		assertEquals("evaH a ecin !yad", anagram.permute(arrayText));
	}

	@Test
	public void testCreateStringArrayExpression() {
		String inputText = "Have a nice day!";
		String[] arrayString = { "Have", "a", "nice", "day!" };
		assertArrayEquals(arrayString, anagram.createStringArray(inputText));
	}

	@Test
	public void testCreateStringArrayExpressionWithManySpace() {
		String inputText = "        Have  a      nice           day!  ";
		String[] arrayString = { "Have", "a", "nice", "day!" };
		assertArrayEquals(arrayString, anagram.createStringArray(inputText));
	}
}
