package ua.com.goit.gojava7.kikstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kikstarter.domain.Category;

public class MemoryCategoryReader {

	public List<Category> readCategories() {
		List<Category> categories = new ArrayList<>();

		categories.add(new Category(1, "Photography"));
		categories.add(new Category(2, "Movie"));
		categories.add(new Category(3, "Recording sound"));

		return categories;
	}

}
