package com.ua.goit.belskii.artem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
	private Convert anagramma;

	@Before
	public void setUp() {
		anagramma = new Convert();
	}

	@Test
	public void test() {
		assertEquals("амам алым умар", anagramma.convert("мама мыла раму"));

	}

}
