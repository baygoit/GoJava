package ua.dborisenko.kickstarter.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.dao.QuoteDao;
import ua.dborisenko.kickstarter.domain.Category;

@Controller
public class CategoryController {

	@Autowired
	private QuoteDao quoteDao;
	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showCategories(Map<String, Object> model) {
		model.put("quote", quoteDao.getRandom());
		model.put("categories", categoryDao.getAll());
		return "categories";
	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public String showCategory(@PathVariable Integer id, Map<String, Object> model) {
		try {
			Category category = categoryDao.getWithProjects(id);
			model.put("category", category);
			model.put("projects", category.getProjects());
		} catch (EmptyResultDataAccessException e) {
			// TODO response.sendError(HttpServletResponse.SC_NOT_FOUND,
			// ErrorText.CATEGORY_NOT_FOUND);
			return "404";
		}

		return "category";
	}
}
