package ua.com.goit.gojava.andriidnikitin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest extends Assert {

public Category category; 
	
	@Before
	public void initialize(){
		category = new Category(); 
	}
	
	@Test
	public void testSmoke() {
		assertNotNull(category);
	}
	
	@Test
	public void testNameNotNull() {
		assertNotNull(category.getName());
	}
	
	@Test
	public void testEmptyNameIfSetAsNull() {//TODO: field must be default or null?
		category.setName(null);
		assertEquals("", category.getName());
	}
	
	@Test
	public void testNullToStringIsNotNull() {
		category = null;
		assertNotNull(category.toString());
	}
	
}
