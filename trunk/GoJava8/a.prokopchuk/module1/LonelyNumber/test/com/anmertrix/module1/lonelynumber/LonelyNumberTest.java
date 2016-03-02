package com.anmertrix.module1.lonelynumber;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LonelyNumberTest {
	
	@Test
	public void testSearchLoneluNumber(){
		int[] numberList = {2, 3, 2, 4, 3, 7, 9, 2, 3, 4, 4};
		
		NumberHelper number = new NumberHelper(numberList);
		
		assertEquals(7, number.getNumber());
	}
}
