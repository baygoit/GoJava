package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

public class CategoryDaoMemoryImpl  implements CategoryDao {
	private List<Category> categories = new ArrayList<>();

	@Override
	public List<Category> getAll() {
		return categories;
	}

	@Override
	public int count() {
		return categories.size();
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
