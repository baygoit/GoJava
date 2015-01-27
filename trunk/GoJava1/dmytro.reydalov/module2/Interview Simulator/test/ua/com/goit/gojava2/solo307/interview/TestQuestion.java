package ua.com.goit.gojava2.solo307.interview;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestQuestion {
	
	Question question;
	
	@Before
	public void setUp() throws Exception {
		question = new Question();
	}

	@Test
	public void testReadInt() {
		int expected = 2;
		int actual = question.readAnswer();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testReadIntTryNotNumber(){
		int expected = 0;
		int actual = question.readAnswer();
		assertEquals(actual, expected);
	}
	
	@Test
	public void testReadIntTryNotExistiong(){
		int expected = 0;
		int actual = question.readAnswer();
		assertEquals(actual, expected);
	}
}
