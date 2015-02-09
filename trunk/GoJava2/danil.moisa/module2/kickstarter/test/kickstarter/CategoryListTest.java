package kickstarter;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CategoryListTest {

	@Test
		public void shouldCategoryList_whenAddCategory(){
			ArrayList<Category> categoryList = new ArrayList<Category>();
				categoryList.add(new Category(1, "name1"));
				categoryList.add(new Category(2, "name2"));
				
				assertEquals("[1. name1, 2. name2]", categoryList.toString());

	}
	
	@Test
	public void shouldCategoryList_whenNoCategory(){
		ArrayList<Category> categoryList = new ArrayList<Category>();
					
			assertEquals("[]", categoryList.toString());

}
	@Test
	public void shouldGetCategoryByIndex_whenAddCategory(){
		ArrayList<Category> categoryList = new ArrayList<Category>();
			Category category1 = new Category(1, "name1");
			categoryList.add(category1);
			Category category2 = new Category(1, "name2");
			categoryList.add(category2);
			
			assertSame(category1, categoryList.get(0));
			assertSame(category2, categoryList.get(1));

}


}
