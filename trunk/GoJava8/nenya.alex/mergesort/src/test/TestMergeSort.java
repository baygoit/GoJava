package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;

import mergesort.EmptyArrayException;
import mergesort.Main;
import mergesort.MergeSort;

import org.junit.Test;

public class TestMergeSort {
	
	@Test(expected = NullPointerException.class)
	public void testSortNull() throws EmptyArrayException {
		int[] array = null;
		new MergeSort().sort(array);
	}

	@Test(expected = EmptyArrayException.class)
	public void testSortEmpty() throws EmptyArrayException {
		int[] array = {};
		new MergeSort().sort(array);
	}

	@Test
	public void testSortNotEmpty() throws EmptyArrayException {
		int[] array = {-12, 10, 7, 0, 5, 7, 1, 77};
		int[] expected = {-12, 0, 1, 5, 7, 7, 10, 77};
		assertEquals(Arrays.toString(expected),
				Arrays.toString(new MergeSort().sort(array)));
	}
	
	//not working in a proper way
	@Test
	public void testMain() throws FileNotFoundException{
		String[] arr = {"A"};
		
		Main.main(arr);
		
		PrintStream out = new PrintStream("Before:	[23, 56, -45, 1, 0, 125, 56, 55, -32]");
		System.setOut(out);
	}
}
