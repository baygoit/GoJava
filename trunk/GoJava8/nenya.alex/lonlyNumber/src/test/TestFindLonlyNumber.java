package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import lonly_number.EmptyArrayException;
import lonly_number.FindLonlyNumber;
import lonly_number.LonlyNumber;

import org.junit.Test;

public class TestFindLonlyNumber {

	@Test
	public void testFindLonlyArrayFull1() throws EmptyArrayException {
		FindLonlyNumber find = new FindLonlyNumber();
		
		
		int[] mas = {-12, 10, 7, 8, 10, 7, 8, 5, 5, 12, 78, 12, 78};
		assertEquals(-12, find.findLonly(mas ));
	}
	
	@Test
	public void testFindLonlyArrayFull2() throws EmptyArrayException {
		FindLonlyNumber find = new FindLonlyNumber();
		
		
		int[] mas = {-12, 10, -12, 7, 8, 10, 7, 8, 5, 5, 12, 78, 12};
		assertEquals(78, find.findLonly(mas ));
	}
	
	@Test
	public void testFindLonlyArrayFull3() throws EmptyArrayException {
		FindLonlyNumber find = new FindLonlyNumber();
		
		
		int[] mas = {-12, 10, -12, 7, 8, 10, 7, 4, 8, 5, 5, 12, 78, 12, 78};
		assertEquals(4, find.findLonly(mas ));
	}

	@Test(expected = EmptyArrayException.class)
	public void testFindLonlyArrayEmpty() throws EmptyArrayException {
		FindLonlyNumber find = new FindLonlyNumber();
		
		int[] mas = {};
		find.findLonly(mas);
	}
	
	@Test(expected = NullPointerException.class)
	public void testFindLonlyArrayNull() throws EmptyArrayException {
		FindLonlyNumber find = new FindLonlyNumber();
		
		int[] mas = null;
		find.findLonly(mas);
	}
	
	//not working in a proper way
	@Test
	public void testLonlyNumber() throws FileNotFoundException{
		String[] arr = {"A"};
		
		LonlyNumber.main(arr);
		
		// 2 - wrong, must be 3
		PrintStream out = new PrintStream("2");
		System.setOut(out);
	}
}
