package com.goit.module1.humeniuk;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMain {
	ConsoleMock mock = new ConsoleMock();

	@Test
	public void test() {
		String[] args = { "" };
		Main.main(args);
		assertEquals("321 123" + "\n", mock.getOut());
	}
	
}
