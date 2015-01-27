package ua.com.goit.gojava2.solo307.interview;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMenu {
	
	Menu menu;
	
	@Before
	public void setUp() throws Exception {
		menu = new Menu();
	}

	@Test
	public void testReadInt() {
		int expected = 37;
		int actual = menu.readInt();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testReadIntTryNotNumber(){
		int expected = 0;
		int actual = menu.readInt();
		assertEquals(actual, expected);
	}
}
