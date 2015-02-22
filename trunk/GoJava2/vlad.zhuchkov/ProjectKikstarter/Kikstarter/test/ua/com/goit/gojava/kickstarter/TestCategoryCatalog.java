package ua.com.goit.gojava.kickstarter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestCategoryCatalog {
	private Category cat;
	private CategoryCatalog catalog;
	@Before
	public void init(){
		this.catalog = new InMemoryCategoryCatalog();
		catalog.addCategory("games");
		this.cat = new InMemoryCategory("games"); 
	}
	@Test
	public void expectCategory_WhenInputCategoryIndex(){
		assertEquals(cat,catalog.getCategory(0));
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void expectException_WhenCatalogIndexOutOfBounds(){
		catalog.getCategory(-1);
	}
	@Test
	public void expectProject_WhenInputProjectIndex(){
		assertEquals("game 1",cat.getProject(0).getName());
	}
	@Test(expected = IlligalInputException.class)
	public void expectException_WhenCategoryIndexOutOfBounds(){
		cat.getProject(-1);
	}
}
