package com.goit.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayGenerator {

	ArrayGenerator ag = new ArrayGenerator(10, 10);

	@Test
	public void testrGetArray() {
		// fail("Not yet implemented");
		assertEquals(ag.array, ag.getArray());
	}

}
