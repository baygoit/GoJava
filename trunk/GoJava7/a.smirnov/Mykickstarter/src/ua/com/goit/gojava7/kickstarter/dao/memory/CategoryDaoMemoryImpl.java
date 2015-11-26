
package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.dao.AbstractCategoryDao;

public class CategoryDaoMemoryImpl extends AbstractCategoryDao {
	
	private List<Category> categories = new ArrayList<>();
	
	public CategoryDaoMemoryImpl() {
		Category category1 = new Category();
		category1.setName("Arts");
		category1.setUniqueID(1);
		
		Category category2 = new Category();
		category2.setName("Sports");
		category2.setUniqueID(2);
		
		Category category3 = new Category();
		category3.setName("Culture");
		category3.setUniqueID(3);
		
		Category category4 = new Category();
		category4.setName("Food");
		category4.setUniqueID(4);
		
		Category category5 = new Category();
		category5.setName("Movie");
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
