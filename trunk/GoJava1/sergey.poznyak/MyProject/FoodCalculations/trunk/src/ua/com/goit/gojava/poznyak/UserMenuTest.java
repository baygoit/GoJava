package ua.com.goit.gojava.poznyak;

import static org.junit.Assert.*;
import java.util.Map;
import org.junit.Test;

/**
 * This class tests UserMenu class.
 * 
 * @version 0.05 03 Feb 2015
 * @author Sergey Poznyak
 */
public class UserMenuTest {
	
	@Test
	public void testUserMenu() {
		UserMenu menu = new UserMenu(null, null);
		assertNotNull(menu);
	}
	
	@Test
	public void testAddDsih() {
		UserMenu menu = new UserMenu();
		menu.addDsih(null);
		assertNotNull(menu.getDishList());
		assertTrue(menu.getDishList().isEmpty());
		menu.addDsih(new Dish());
		assertFalse(menu.getDishList().isEmpty());
	}

	@Test
	public void testCalculateWeights() {
		UserMenu menu = new UserMenu(7, ListServiceHardcodedData.getDishList());
		Map<Foodstuff, Integer> listWeights = menu.calculateWeights();
		assertNotNull(listWeights);
		assertEquals(3, listWeights.size());
	}

}