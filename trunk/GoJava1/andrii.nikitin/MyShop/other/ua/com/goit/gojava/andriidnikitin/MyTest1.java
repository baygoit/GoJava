package ua.com.goit.gojava.andriidnikitin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Test;

public class MyTest1 {


	
	@Test
	public void addTest(){
		ChooseGoodsImpl choser = new ChooseGoodsImpl();
		Good good  = new Good();
		good.setCategory(new Category());
		good.setId(123);
		good.setName("default");
		good.setPrice(new BigDecimal("10"));
		choser.add(good, 0);
		assertEquals(0, new BigDecimal("0").compareTo(choser.total()));
		choser.add(good, 5);
		assertEquals(0, new BigDecimal("50").compareTo(choser.total()));
		choser.add(good, -100);
		assertEquals(0, new BigDecimal("0").compareTo(choser.total()));
		choser.add(good, 5);
		choser.delete(good);
		assertTrue(choser.basket.getOrder().get(good) == null);
		assertEquals(0, new BigDecimal("0").compareTo(choser.total()));		
		Basket tempBasket = choser.basket;
		choser.cancelChoice();
		assertTrue(choser.basket != tempBasket);
	}
	

	
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
	public void getCategoryListTest1() {
		final StorageImpl store = new StorageImpl(); 
		assertNotNull(store.getCategoryList());
	}
						
	@Test
	public void getGoodListTest1() {
		final StorageImpl store = new StorageImpl(); 
		assertNotNull(store.getGoodList());
		
		List<Good> emptyGoodList = new ArrayList<Good>();
		
		assertEquals(emptyGoodList, store.getGoodList(null));
		
		Category category = new Category();
		assertEquals(emptyGoodList, store.getGoodList(category));
	}
	
	/*@Test
	public void modifiancTest() throws JAXBException {
		final StorageXmlOld store = new StorageXmlOld();
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
	}*/
	
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
	

}
