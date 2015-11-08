package com.goit.kickstarter.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.goit.kickstarter.model.Category;

@Component
public class CategoryDAO extends AbstractDAO {

	@Transactional
	public Category getCategory(int id) {
		Category cat = (Category) getSession().get(Category.class, id);
		
		return cat;
	}

	@Transactional
	public List<Category> getCategories() {
		@SuppressWarnings("unchecked")
		List<Category> list = (List<Category>) getSession().createCriteria(Category.class).list();
		
		return list;
	}
}