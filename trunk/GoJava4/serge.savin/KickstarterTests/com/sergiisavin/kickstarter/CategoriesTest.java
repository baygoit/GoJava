package com.sergiisavin.kickstarter;

import static org.junit.Assert.*;

import javax.naming.OperationNotSupportedException;

import org.junit.Before;
import org.junit.Test;

import com.sergiisavin.kickstarter.category.Category;
import com.sergiisavin.kickstarter.category.container.Categories;
import com.sergiisavin.kickstarter.category.container.memory.CategoriesContainer;

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
		try {
			categories.add(category);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(size+1, categories.getSize());		
		System.out.println(categories.toString());
		
	}
	
	@Test
	public void testGetCategoriesSize(){
		assertEquals(3, categories.getSize());
	}
	
	@Test(expected=Categories.IllegalArgumentException.class)
	public void throwsIllegalArgumentExceptionIfArgumentIsNull(){
		Category category = null;
		try {
			categories.add(category);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(expected=Categories.IllegalArgumentException.class)
	public void throwsIllegalArgumentExceptionIfArgumentIsLessThanZero(){
		int index = -2;
		categories.get(index);
	}

}
