package ua.com.goit.gojava.andriidnikitin;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GoodStorageImplTest {
	
	public GoodStorageImpl store; 
	
	@Before
	public void initialize(){
		store = new GoodStorageImpl(); 
	}
	
	@Test
	public void getCategoryListTest() {
		assertNotNull(store.getCategoryList());
		
	}
						
	@Test
	public void getGoodList() {
		assertNotNull(store.getGoodList());
		List<Good> emptyGoodList = new ArrayList<Good>();
		assertEquals(emptyGoodList, store.getGoodList(null));
		Category category = new Category();
		assertEquals(emptyGoodList, store.getGoodList(category));
	}
}