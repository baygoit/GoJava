package ua.goit.goitjava.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputTest {

	@Test
	public void InputTest() {
		Input i = new Input();
		assertEquals(1,i.scanInt());
	}

}
