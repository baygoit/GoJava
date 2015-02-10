package ua.com.goit.gojava.andriidnikitin;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StorageImplTest {
	
	@Test
	public void constructorTest() {
		final List<Category> categoryList = new ArrayList<Category>();
		final List<Good> goodList = new ArrayList<Good>();
		final StorageImpl store = new StorageImpl()
												.setCategoryList(categoryList)
												.setGoodList(goodList);
		assertEquals(categoryList, store.getCategoryList());
		assertEquals(goodList, store.getGoodList());
		
	}
	
	@Test
	public void getCategoryListTest() {
		final StorageImpl store = new StorageImpl(); 
		assertNotNull(store.getCategoryList());
	}
						
	@Test
	public void getGoodListTest() {
		final StorageImpl store = new StorageImpl(); 
		assertNotNull(store.getGoodList());
		
		List<Good> emptyGoodList = new ArrayList<Good>();
		
		assertEquals(emptyGoodList, store.getGoodList(null));
		
		Category category = new Category();
		assertEquals(emptyGoodList, store.getGoodList(category));
	}
	
	/*@Test
	public void nullFieldBehaviorTest(){
		final GoodStorageImpl store = new GoodStorageImpl()
											.setCategoryList(null)
											.setGoodList(null);		
		try {
			store.save(new Good());
			fail();
		} catch(NullPointerException exception){
			
		}
		try {
			store.save(new Category());
		} catch(NullPointerException exception){
			
		}
	}
	
	@Test
	public void emptyFieldBehaviorTest(){
		
	}*/
}