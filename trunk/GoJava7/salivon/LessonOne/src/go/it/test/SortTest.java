package go.it.test;

import go.it.main.Sort;
import go.it.salivon.InsertionSort;
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class SortTest {

	private static Sort util;

	@BeforeClass
	public static void setUp() throws Exception {
		util = new InsertionSort();
	}

	@Test(expected = NullPointerException.class)
	public void testNullList() {
		util.sort(null);
	}

	@Test
	public void testEmptyList() {
		List<Integer> input = new ArrayList<>();
		List<Integer> result = util.sort(input);
		assertEquals(Collections.emptyList(), result);
	}

	@Test
	public void testSimpleList() {
		List<Integer> input = Arrays.asList(5, 1, 234, 5, 543, 2);
		List<Integer> result = util.sort(input);
		assertEquals(Arrays.asList(1, 2, 5, 5, 234, 543), result);
	}


}
