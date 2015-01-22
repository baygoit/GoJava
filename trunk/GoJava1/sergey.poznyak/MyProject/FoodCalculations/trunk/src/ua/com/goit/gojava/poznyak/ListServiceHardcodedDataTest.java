package ua.com.goit.gojava.poznyak;

import static org.junit.Assert.*;

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
	public void testGetDishListNotNull() {
		assertNotNull(service.getDishList());
	}
	
	@Test
	public void testGetDishListNotEmpty() {
		assertFalse(service.getDishList().isEmpty());
	}

	@Test
	public void testGetIngredientListNotNull() {
		assertNotNull(service.getIngredientList(77));
	}
	
	@Test
	public void testGetIngredientListZero() {
		assertNotNull(service.getIngredientList(0));
	}
	
	@Test
	public void testGetIngredientListNotEmpty() {
		assertFalse(service.getIngredientList(2).isEmpty());
	}
	
	@Test
	public void testGetIngredientMax() {
		assertNotNull(service.getIngredientList(Integer.MAX_VALUE));
	}
	
	@Test
	public void testGetIngredientMin() {
		assertNotNull(service.getIngredientList(Integer.MIN_VALUE));
	}

}
