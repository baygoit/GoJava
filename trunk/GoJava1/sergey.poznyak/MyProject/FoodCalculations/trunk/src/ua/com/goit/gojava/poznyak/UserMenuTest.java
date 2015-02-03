package ua.com.goit.gojava.poznyak;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class UserMenuTest {

	@Test
	public void testCalculateWeights() {
		UserMenu menu = new UserMenu(7, ListServiceHardcodedData.getDishList());
		Map<Foodstuff, Integer> listWeights = menu.calculateWeights();
		assertNotNull(listWeights);
		assertEquals(3, listWeights.size());
	}

}