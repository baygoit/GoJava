package ua.com.goit.gojava2.solo307.interview;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestInterview {

	Interview interview;
	
	@Before
	public void setUp() throws Exception {
		interview = new Interview();
	}

	@Test
	public void testIsPassed() {
		boolean expected = true;
		int myNumber = 4;
		boolean actual = interview.isPassed(myNumber);
		assertEquals(expected, actual);
	}

	@Test
	public void testIsPassedFalse() {
		boolean expected = false;
		int myNumber = 2;
		boolean actual = interview.isPassed(myNumber);
		assertEquals(expected, actual);
	}
}
