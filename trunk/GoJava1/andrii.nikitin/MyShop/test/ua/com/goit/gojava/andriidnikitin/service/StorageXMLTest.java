package ua.com.goit.gojava.andriidnikitin.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import ua.com.goit.gojava.andriidnikitin.model.Category;
import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.service.StorageImpl;
import ua.com.goit.gojava.andriidnikitin.service.StorageXml;

public class StorageXMLTest {
	
	@Test
	public void modifiancTest() throws JAXBException {
		final StorageXml store = new StorageXml();
		assertNotNull(store);	
		Good good = StorageImpl.setId(
				new Good()	
					.setName("TEST")
					.setCategory(store.getCategoryList().get(1))
					.setPrice(new BigDecimal(45.990778))
		);
		store.save(good);
		store.saveChanges();
		assertTrue(store.getGoodList(good.getCategory()).contains(good));
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