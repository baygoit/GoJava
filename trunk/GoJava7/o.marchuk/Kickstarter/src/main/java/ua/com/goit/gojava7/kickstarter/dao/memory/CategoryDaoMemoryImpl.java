package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;

@Repository
public class CategoryDaoMemoryImpl implements CategoryDao {
	private List<Category> categories = new ArrayList<Category>();

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public List<Category> getAll() {
		return Collections.unmodifiableList(categories);
	}

	@Override
	public int count() {
		return categories.size();
	}
}
