package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.model.Category;

public class CategoryDaoMemoryImpl implements CategoryDao{
	private List<Category> categories = new ArrayList<>();
	@Override
	public List<Category> getAll() {
		return categories;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return categories.size();
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
}
