package ua.com.goit.gojava.poznyak;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests ListServiceHardcodedData class.
 * 
 * @version 0.04 28 Jan 2015
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
	public void testGetIngredientList() {
		List<Dish> dishList = ListServiceHardcodedData.getDishList();
		assertNotNull(ListServiceHardcodedData.getIngredientList(null));
		assertNotNull(ListServiceHardcodedData.getIngredientList(new Dish()));
		assertNotNull(ListServiceHardcodedData.getIngredientList(dishList.get(4)));
	}

}
