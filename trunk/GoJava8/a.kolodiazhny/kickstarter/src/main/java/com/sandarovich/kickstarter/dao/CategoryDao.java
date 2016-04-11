package com.sandarovich.kickstarter.dao;

import java.util.List;

import com.sandarovich.kickstarter.dao.exception.NoResultException;
import com.sandarovich.kickstarter.model.Category;
import com.sandarovich.kickstarter.model.Project;

public interface CategoryDao {
    List<Category> getCategories();

	/**
	 * @param id
	 * @throws NoResultException
	 *             dfhfggh
	 * @return
	 */
    Category findCategoryById(int id);
    Category findCategoryByProject(Project project);
}
