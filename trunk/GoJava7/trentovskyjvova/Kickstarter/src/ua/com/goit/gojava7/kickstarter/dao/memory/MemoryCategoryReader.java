package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.CategoryReader;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class MemoryCategoryReader implements CategoryReader {

	@Override
	public List<Category> readCategories() {
		List<Category> categories = new ArrayList<>();

		categories.add(new Category("Games", 1));
		categories.add(new Category("Design", 2));
		categories.add(new Category("Film & Video", 3));
		categories.add(new Category("Technology", 4));
		return categories;
	}

}
