package ua.com.goit.gojava.poznyak;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests ListServiceHardcodedData class
 * 
 * @version 0.03 22 Jan 2015
 * @author Sergey Poznyak
 */
public class ListServiceHardcodedDataTest {
	
	private ListService service;
	
	@Before 
	public void initialize() {
		service = new ListServiceHardcodedData();
	}

	@Test
	public void testGetDishList() {
		List<Dish> dishList = service.getDishList();
		assertNotNull(dishList);
		assertEquals(5, dishList.size());
		assertEquals("1. Borshch", dishList.get(0).toString());
	}

	@Test
	public void testGetIngredientList() {
		assertNotNull(service.getIngredientList(Integer.MAX_VALUE));
		assertNotNull(service.getIngredientList(Integer.MIN_VALUE));
		assertEquals(3, service.getIngredientList(2).size());
		assertEquals("salt x 0.005kg", service.getIngredientList(2).get(1).toString());
	}

}
