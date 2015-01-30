package ua.com.goit.gojava.andriidnikitin;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GoodStorageImplTest {
	
	@Test
	public void constructorTest() {
		final List<Category> categoryList = new ArrayList<Category>();
		final List<Good> goodList = new ArrayList<Good>();
		final GoodStorageImpl store = new GoodStorageImpl()
												.setCategoryList(categoryList)
												.setGoodList(goodList);
		assertEquals(categoryList, store.getCategoryList());
		assertEquals(goodList, store.getGoodList());
		
	}
	
	@Test
	public void getCategoryListTest() {
		final GoodStorageImpl store = new GoodStorageImpl(); 
		assertNotNull(store.getCategoryList());
	}
						
	@Test
	public void getGoodListTest() {
		final GoodStorageImpl store = new GoodStorageImpl(); 
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