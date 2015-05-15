package com.sergiisavin.kickstarter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CategoriesTest {

	private Categories categories;
	
	@Before
	public void setup(){
		categories = new CategoriesContainer("Игры", "Роботы", "Гаджеты");
	}
	
	@Test
	public void testCategoriesToString(){
		System.out.println(categories.toString());	
	}
	
	@Test
	public void testGetCategory() {
		assertNotNull(categories.get(1));
		System.out.println(categories.get(1).toString());
		assertEquals("Роботы", categories.get(1).toString());
	}
	
	@Test
	public void testAddCategory(){
		int size = categories.getSize();
		Category category = new Category("Транспортные средства");
		categories.add(category);
		assertEquals(size+1, categories.getSize());		
		System.out.println(categories.toString());
		
	}
	
	@Test
	public void testGetCategoriesSize(){
		assertEquals(3, categories.getSize());
	}

}
