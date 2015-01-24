package ua.com.goit.gojava.andriidnikitin;


import static org.junit.Assert.*;
import org.junit.Test;

public class GoodTest {

public Good good; 
	
	@Test
	public void createInstanceTest() {
		final Good goodEmpty = new Good();
		assertNull(goodEmpty.getName());
		assertNull(goodEmpty.getCategory());
		
		final Good goodSetter = new Good();
		goodSetter.setName("default");
		assertEquals("default", goodSetter.getName());
		
		Category defaultCategory = new Category(0, "default");		
		final Good goodConstructor = new Good(100, "default", defaultCategory);
		assertEquals("default", goodConstructor.getName());		
		assertEquals(defaultCategory, goodConstructor.getCategory());		
		assertEquals(100, goodConstructor.getId());		
	}	   
}
