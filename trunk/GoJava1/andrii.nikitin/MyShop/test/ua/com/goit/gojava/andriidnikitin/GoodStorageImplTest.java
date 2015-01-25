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
	
	@Test
	public void categoryExistsTest() {
		final GoodStorageImpl store = new GoodStorageImpl(); 
		List<Category> list = store.getCategoryList();
		Category category = list.get(0);
		assertEquals(true, store.categoryExists(category));
		assertEquals(false, store.categoryExists(null));
		assertEquals(false, store.categoryExists(new Category()));
	}
	
	@Test
	public void goodExistsTest() {
		final GoodStorageImpl store = new GoodStorageImpl(); 
		List<Good> list = store.getGoodList();
		Good good = list.get(0);
		assertEquals(true, store.goodExists(good));
		assertEquals(false, store.goodExists(null));
		assertEquals(false, store.goodExists(new Good()));
	}
	
	@Test
	public void addCategoryTest() {
		final GoodStorageImpl store = new GoodStorageImpl(); 
		Category category = new Category("default");
		store.addCategory(category);
		try {
			store.addCategory(category);
			fail();
		} catch (IllegalArgumentException exception) {
		}
		

		Category nullCategory = null;		
		try {
			store.addCategory(nullCategory);
			fail();
		} catch (IllegalArgumentException exception) {
		}
	}
	
	@Test
	public void addGoodTest() {
		final GoodStorageImpl store = new GoodStorageImpl(); 
		
		final Category category = store.getCategoryList().get(0);
		final Good good = new Good(100, "default", category);
		store.addGood(good);
		assertEquals(true, store.goodExists(good));
		try {
			store.addGood(good);
			fail();
		} catch (IllegalArgumentException exception) {
		}
		

		final Good nullGood = null;		
		try {
			store.addGood(nullGood);
			fail();
		} catch (IllegalArgumentException exception) {
		}
		

		final Category newCategory = new Category("default");	
		final Good illegalGood = new Good(105, "default", newCategory);		
		try {
			store.addGood(illegalGood);
			fail();
		} catch (IllegalArgumentException exception) {
		}	
	}
	
	@Test
	public void nullFieldBehaviorTest(){
		final GoodStorageImpl store = new GoodStorageImpl()
											.setCategoryList(null)
											.setGoodList(null);		
		try {
			store.addGood(new Good());
			fail();
		} catch(NullPointerException exception){
			
		}
		try {
			store.addCategory(new Category());
		} catch(NullPointerException exception){
			
		}
	}
	
	@Test
	public void emptyFieldBehaviorTest(){
		
	}
}