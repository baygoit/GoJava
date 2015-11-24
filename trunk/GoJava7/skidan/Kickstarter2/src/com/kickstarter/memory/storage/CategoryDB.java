package com.kickstarter.memory.storage;

import java.util.ArrayList;
import java.util.List;

import com.kickstarter.model.Category;

public class CategoryDB {

	public CategoryDB() {

		categorylist = fillList();

	
	}

	public List<Category> categorylist = new ArrayList<>();

	private List<Category> fillList() {

		List<Category> categorylist = new ArrayList<>(10);
		categorylist.add(new Category("it", 1));
		categorylist.add(new Category("education", 2));
		categorylist.add(new Category("sport", 3));

		return categorylist;

	}

}
