package ua.com.goit.gojava.poznyak;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

/**
 * This class tests ListServiceHardcodedData class.
 * 
 * @version 0.1 11 Feb 2015
 * @author Sergey Poznyak
 */
public class ListServiceHardcodedDataTest {

	@Test
	public void testGetDishList() {
		List<Dish> dishList = ListServiceHardcodedData.getDishList();
		assertNotNull(dishList);
		assertEquals(5, dishList.size());
		assertEquals("1. Borshch", dishList.get(0).toString());
	}

	@Test
	public void testGetFoodstuffList() {
		List<Foodstuff> foodstuffList = ListServiceHardcodedData.getFoodstuffList();
		assertNotNull(foodstuffList);
		assertEquals("buckwheat", foodstuffList.get(0).toString());
	}

}
