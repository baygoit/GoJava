package com.kickstarter.dao.interfaces;

import java.util.List;

import com.kickstarter.model.Category;

public interface CategoryDao {

	public List<Category> getAll();
	
	public Category getByNumber(int categoryNumber);
}
