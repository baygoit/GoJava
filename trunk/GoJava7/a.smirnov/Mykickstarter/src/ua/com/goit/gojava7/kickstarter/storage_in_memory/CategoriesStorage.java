
package ua.com.goit.gojava7.kickstarter.storage_in_memory;

import ua.com.goit.gojava7.kickstarter.dao.AbstractMemoryStorage;
import ua.com.goit.gojava7.kickstarter.model.Category;

public class CategoriesStorage extends AbstractMemoryStorage<Category> {
	
	public CategoriesStorage() {
		Category category1 = new Category("Arts");
		Category category2 = new Category("Movie");
		Category category3 = new Category("Sports");
		Category category4 = new Category("Culture");
		Category category5 = new Category("Food");

		category1.setUniqueID(1);
		category2.setUniqueID(2);
		category3.setUniqueID(3);
		category4.setUniqueID(4);
		category5.setUniqueID(5);
		
		add(category1);
		add(category2);
		add(category3);
		add(category4);
		add(category5);
		
	}
}
