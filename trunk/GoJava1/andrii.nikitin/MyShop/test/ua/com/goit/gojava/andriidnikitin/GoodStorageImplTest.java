package ua.com.goit.gojava.andriidnikitin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoodStorageImplTest extends Assert {
	
	public GoodStorageImpl store; 
	
	@Before
	public void initialize(){
		store = new GoodStorageImpl(); 
	}
	
	@Test
	public void testSmoke() {
		assertNotNull(store);
	}
	
	@Test
	public void testCategoryListNotNull(){
		assertNotNull(store.getCategoryList());
	}
	
	@Test
	public void testGoodListNotNull(){
		assertNotNull(store.getGoodList());
	}
	
	@Test
	public void testGoodFromNullCategoryIsNull(){
		assertNull(store.getGoodList(null));
	}
	
	@Test
	public void testGetGoodFromUnexistingCategoryIsNull(){
		Category category = new Category();
		assertNull(store.getGoodList(category));
	}	
	
	
}
