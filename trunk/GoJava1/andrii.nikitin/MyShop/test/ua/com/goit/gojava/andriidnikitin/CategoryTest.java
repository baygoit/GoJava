package ua.com.goit.gojava.andriidnikitin;

import static org.junit.Assert.*;

import org.junit.Test;
public class CategoryTest {

	public Category category; 
	
	@Test
	public void createInstanceTest() {
		final Category categoryEmpty = new Category();
		assertNull(categoryEmpty.getName());
		
		final Category categorySetter = new Category();
		categorySetter.setName("default");
		assertEquals("default", categorySetter.getName());
		
		final Category categoryConstructor = new Category("default");
		assertEquals("default", categoryConstructor.getName());		
		
	}	   
}
