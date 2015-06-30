package ua.com.goit.belskii.artem;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
	Distance list;

	@Before
	public void setUp() {
		list = new Distance();
	}

	@Test
	public void testMin() {
		int[] elements = { 5, 7, 2, 16, 13, 4 };
		assertEquals(2, list.findMin(elements));
	}

	@Test
	public void testMin1() {
		int[] elements = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		assertEquals(1, list.findMin(elements));
	}

	@Test
	public void testMax() {
		int[] elements = { 5, 7, 2, 16, 13, 4 };
		assertEquals(16, list.findMax(elements));
	}

	@Test
	public void testMax1() {
		int[] elements = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		assertEquals(9, list.findMax(elements));
	}

	@Test
	public void testPosition() {
		int[] elements = { 5, 7, 2, 16, 13, 4 };
		assertEquals(0, list.findPosition(elements, 5));
	}

	@Test
	public void testPosition2() {
		int[] elements = { 5, 7, 2, 16, 13, 4 };
		assertEquals(3, list.findPosition(elements, 16));
	}

	@Test
	public void testPosition3() {
		int[] elements = { 5, 7, 2, 16, 13, 16 };
		assertEquals(3, list.findPosition(elements, 16));
	}

	@Test
	public void testDistance() {
		int[] elements = { 5, 7, 2, 1, 13, 16 };
		assertEquals(2, list.findDistance(elements));
	}

	@Test
	public void testDistance1() {
		int[] elements = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		assertEquals(8, list.findDistance(elements));
	}

}
