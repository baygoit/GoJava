package ua.com.goit.gojava7.kickstarter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;

@RestController
@RequestMapping("/rest")
public class CategoryRestService {

	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping("/category/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId) {
		Category category = categoryDao.get(categoryId);
		return category;
	}
}