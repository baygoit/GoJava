package com.go_java4.alex_mirn;


	import static org.junit.Assert.*;


	import org.junit.Test;

	import com.go_java4.alex_mirn.data.Category;
	import com.go_java4.alex_mirn.data_containers.CategoriesContainer;

	public class CategoriesContainerTest {
		
		@Test
		public void shouldEmptyCategoriesList_whenCreate() {
			CategoriesContainer list = new CategoriesContainer();
				
			assertEquals("[]", list.getCategories().toString());
		}
		
		@Test
		public void shouldAddCategory_whenAddCategoryToList() {
			CategoriesContainer list = new CategoriesContainer();
			
			Category category1 = new Category("Name1");
			Category category2 = new Category("Name2");
			
			list.add(category1); 
			list.add(category2); 
			
			assertEquals("[Name1, Name2]", list.getCategories().toString());
		}
		
		@Test
		public void shouldGetCategoryByIndex_whenAddCategoryToList() {
			CategoriesContainer list = new CategoriesContainer();
			
			Category category1 = new Category("Name1");
			Category category2 = new Category("Name1");
			
			list.add(category1); 
			list.add(category2); 
			
			assertSame(category1, list.get(0));
			assertEquals(category2, list.get(1));
		}
		
		@Test
		public void shouldReturnSizeOfContainer_whenAskForIt() {
			CategoriesContainer list = new CategoriesContainer();
			
			assertEquals(0, list.size());
			
			Category category1 = new Category("Name1");
			Category category2 = new Category("Name2");
			Category category3 = new Category("Name3");
			
			list.add(category1); 
			list.add(category2); 
			list.add(category3); 
			
			assertEquals(3, list.size());
		}
	}
