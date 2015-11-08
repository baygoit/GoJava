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
		int[] elements = { 23, 45, 34, 12, 45, 4, 38, 56, 2, 49, 100, };
		assertEquals(-3, list.findDistance(elements));
	}

	@Test
	public void testDistance1() {
		int[] elements = { 1, 9, 3, 4, 5, 6, 7, 8, 2 };
		assertEquals(8, list.findDistance(elements));
	}

}
