package com.go_java4.alex_mirn.data_containers;

import java.util.ArrayList;
import java.util.List;

import com.go_java4.alex_mirn.data.Category;

public class CategoriesContainer {
	private List<Category> categories;

	public CategoriesContainer() {
		categories = new ArrayList<Category>();
	}

	public Category get(int index) {
		return categories.get(index);
	}

	public int size() {
		return categories.size();
	}

	public void add(Category category) {
		categories.add(category);
	}

	public List<Category> getCategories() {
		return categories;
	}
}
