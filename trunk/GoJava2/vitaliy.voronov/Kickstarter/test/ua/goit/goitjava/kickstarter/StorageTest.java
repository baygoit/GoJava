package ua.goit.goitjava.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

public class StorageTest {

	@Test
	public void QuoteTest() {
		Storage s = new Storage();
		assertEquals(4, s.getSize());
	}

}
