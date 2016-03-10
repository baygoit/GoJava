package com.goit.calculator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestCalculator {
	Calculator calculator;
	List<Integer> inputArray;
	List<Integer> outputArray;

	@Test
	public void getDistanceBetvenTwoElements() {
		inputArray = Arrays.asList(1, 10, -5, 5, 8, 14, 125, 0, 9, 80);
		outputArray = Arrays.asList(5);
		calculator = new Calculator(inputArray);
		assertEquals(outputArray, calculator.getDistance());
	}

	@Test(expected = NullPointerException.class)
	public void getDistanceOneElementExceptionTest() {
		inputArray = new ArrayList<Integer>();
		inputArray.add(0);
		assertEquals(NullPointerException.class, calculator.getDistance());
	}
	
	@Test(expected = NullPointerException.class)
	public void getDistanceEmptyInputArrayTest() {
		inputArray = new ArrayList<Integer>();
		assertEquals(NullPointerException.class, calculator.getDistance());
	}
	
	@Test
	public void getDistanceBetvenSevetalFirstElements(){
		inputArray = Arrays.asList(1, 10, 0, 5, 0, 14, 125, 0, 9, 80);
		outputArray = Arrays.asList(2, 5, 3);
		calculator = new Calculator(inputArray);
		assertEquals(outputArray, calculator.getDistance());
	}

	@Test
	public void getDistanceBetvenSevetalSecondElements(){
		inputArray = Arrays.asList(1, 10, 0, 5, 0, -14, 125, 0, 9, 80);
		outputArray = Arrays.asList(3, 1, 2);
		calculator = new Calculator(inputArray);
		assertEquals(outputArray, calculator.getDistance());
	}
}
