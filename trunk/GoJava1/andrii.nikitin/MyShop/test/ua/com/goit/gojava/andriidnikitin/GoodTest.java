package ua.com.goit.gojava.andriidnikitin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoodTest extends Assert {

public Good good; 
	
	@Before
	public void initialize(){
		good = new Good(); 
	}
	
	@Test
	public void testSmoke() {
		assertNotNull(good);
	}
}
