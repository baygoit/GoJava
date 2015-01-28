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
	
	
	private List<Dish> dishList;
	
	@Before 
	public void initialize() {
		dishList = ListServiceHardcodedData.getDishList();
	}

	@Test
	public void testGetDishList() {
		assertNotNull(dishList);
		assertEquals(5, dishList.size());
		assertEquals("1. Borshch", dishList.get(0).toString());
	}

	@Test
	public void testGetIngredientList() {
		assertNotNull(ListServiceHardcodedData.getIngredientList(null));
		assertNotNull(ListServiceHardcodedData.getIngredientList(new Dish()));
		assertNotNull(ListServiceHardcodedData.getIngredientList(dishList.get(4)));
	}

}
