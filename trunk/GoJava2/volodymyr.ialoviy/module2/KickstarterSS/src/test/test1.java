package test;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import mainkick.Category;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class test1 {

	@Test
    public void simpleMocking() throws FileNotFoundException{
		Category category = mock(Category.class);
		
		String s = category.showAllProjectInCategory(2);
		assertFalse(s.equals("2, Progect-2, shortDescription-2, 1000, 990\n"
				 + "5, Progect-5, shortDescription-5, 1000, 990\n"
				 + "6, Progect-6, shortDescription-6, 1000, 990"));
    }
	
	@Test
	public void shouldNotisEmpty_expectedEmpty() throws FileNotFoundException {
		
		int rezult = 1;
		assertEquals(2, rezult); 
	 }
	
}