package com.kickstarter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kickstarter.dao.Interfaces.CategoryDao;
import com.kickstarter.model.Category;


@RestController
@RequestMapping("/rest")
public class CategoryRest {

	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping("/category/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") int categoryId) {
		Category category = categoryDao.getByNumber(categoryId);
		return category;
	}
}