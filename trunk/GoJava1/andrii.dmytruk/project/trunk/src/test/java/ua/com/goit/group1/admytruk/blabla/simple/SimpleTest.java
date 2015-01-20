package ua.com.goit.group1.admytruk.blabla.simple;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleTest {

	private DataManager dataManager;
	
	@Before
	public void init() throws Exception {
		dataManager = new DataManager();
	}
	
	@Test
	public void categoryTest() {
		assertNotNull("The Datamanager has not been initialized", dataManager);
		
		// use case #1:
		assertNotNull(dataManager.getCategoryList());
		assertEquals(3, dataManager.getCategoryList().size());

		// use case #2:		
		final Category category = getCategory(dataManager.getCategoryList(), 1); 
		assertNotNull(category);		
		
		final List<Product> productList = dataManager.getProductList(category);
		assertEquals(3, productList.size());
		assertEquals("Product - 001", getProduct(productList, 1).getName());
		assertEquals("Product - 002", getProduct(productList, 2).getName());
		assertEquals("Product - 003", getProduct(productList, 3).getName());
	}
	
	public Category getCategory(List<Category> list, int id) {
		if (list == null) {
			return null;
		}
		for (Category category : list) {
			if (category != null && category.getId() != null && id == category.getId()) {
				return category;
			}
		}
		return null;
	}
	
	public Product getProduct(List<Product> list, int id) {
		if (list == null) {
			return null;
		}
		for (Product product : list) {
			if (product != null && product.getId() != null && id == product.getId()) {
				return product;
			}
		}
		return null;
	}
		
}
