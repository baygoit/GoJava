package com.go_java4.alex_mirn;


	import static org.junit.Assert.*;

	import org.junit.Test;

	import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Quote;
import com.go_java4.alex_mirn.data_containers.CategoriesContainer;
import com.go_java4.alex_mirn.data_containers.EntityContainer;

	public class CategoriesContainerTest extends EntityContainer<Category>{
		
		@Test
		public void shouldAddCategory_whenAddCategoryToList() {
			CategoriesContainer list = new CategoriesContainer();
			
			Category category1 = new Category(1, "Name1");
			Category category2 = new Category(2, "Name2");
			
			list.add(category1); 
			list.add(category2); 
			
			assertEquals("[Name1, Name2]", list.getData().toString());
		}
		
		@Test
		public void shouldgetId_whenCreateCategory() {	
			Category category1 = new Category(1, "Name1");
			Category category2 = new Category(100, "Name2");
			
			assertEquals(1, category1.getId());
			assertEquals(100, category2.getId());
		}

	}
