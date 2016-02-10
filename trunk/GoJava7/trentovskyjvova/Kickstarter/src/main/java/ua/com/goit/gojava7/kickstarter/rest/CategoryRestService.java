package ua.com.goit.gojava7.kickstarter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;

@RequestMapping("/rest")
@RestController
public class CategoryRestService{

	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping("/categories")
	public List<Category> getCategories() {

		return categoryDao.getCategories();
	}
	
	@RequestMapping("/category/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId) {

		return categoryDao.getCategory(categoryId);
	}
}
