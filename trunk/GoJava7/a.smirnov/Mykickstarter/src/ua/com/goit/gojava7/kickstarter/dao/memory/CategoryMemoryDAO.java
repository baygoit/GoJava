
package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.dao.AbstractCategoryStorage;

public class CategoryMemoryDAO extends AbstractCategoryStorage {
	
	private List<Category> categories = new ArrayList<>();
	
	public CategoryMemoryDAO() {
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

	@Override
	public void add(Category category) {
		categories.add(category);
	}

	@Override
	public void remove(Category category) {
		categories.remove(category);
	}

	@Override
	public List<Category> getAll() {
		return categories;
	}

	@Override
	public int getSize() {
		return categories.size();
	}
}
