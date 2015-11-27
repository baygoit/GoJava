package com.kickstarter.dao.interfaces;

import java.util.List;

import com.kickstarter.model.Category;

public abstract class CategoryDaoType {

	public CategoryDaoInterface categoryDaoInterface;

	public CategoryDaoType() {

	}

	public List<Category> getAllCategories() {

		return categoryDaoInterface.getAll();

	}

	public Category getCategorieByNumber(int categoryNumber) {

		return categoryDaoInterface.getByNumber(categoryNumber);

	}

	public void setType(CategoryDaoInterface categoryDaoInterface) {
		this.categoryDaoInterface = categoryDaoInterface;
	}
}
