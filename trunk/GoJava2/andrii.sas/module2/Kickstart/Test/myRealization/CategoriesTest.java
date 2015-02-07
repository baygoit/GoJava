package myRealization;

import static org.junit.Assert.*;

import org.junit.Test;

public class CategoriesTest {
	
	@Test
	public void shouldMakeList_whenCategoryAdded(){
		//given
		Categories list = new Categories();
		
		//when
		Category category1 = new Category("Category1");
		Category category2 = new Category("Category2");
		list.addCategory(category1);
		list.addCategory(category2);
		
		//then
		assertEquals("1 - Category1, 2 - Category2", list.getCategories());
	}
	
	@Test
	public void shouldReturnEmptyString_whenNoOneCategories(){
		//given
		Categories list = new Categories();
		
		//when
		String categories = list.getCategories();
		
		//then		
		assertEquals("", categories);
	}


	@Test
	public void shouldGetCategoryByIndex_whenItAdded(){
		//given
		Categories list = new Categories();
		
		//when
		Category category1 = new Category("Category1");
		Category category2 = new Category("Category2");
		list.addCategory(category1);
		list.addCategory(category2);
		
		//then
		assertSame(category1, list.readCategory(0));
		assertSame(category2, list.readCategory(1));
	}
}