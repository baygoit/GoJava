package ua.nenya.controller.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import ua.nenya.controller.jsp.CategoryController;
import ua.nenya.dao.CategoryDao;
import ua.nenya.domain.Category;

@RestController
@RequestMapping("/rest")
public class CategoriesRestController {

	@Autowired
	private CategoryDao categoryDao;

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@RequestMapping(value = "/category/", method = RequestMethod.GET)
	public List<Category> getAllCategories() {
		return categoryDao.getCategories();
	}

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public Category getCategory(@PathVariable("categoryId") Long categoryId) {
		if (!categoryDao.isCategoryExistById(categoryId)) {
			logger.error("Category with id " + categoryId + " dosen't exist!");
			return new Category();
		}
		Category category = categoryDao.getCategoryByCategoryId(categoryId);
		return category;
	}

	@RequestMapping(value = "/category/{categoryId}/delete", method = RequestMethod.DELETE)
	public String deleteCategory(@PathVariable("categoryId") Long categoryId) {
		if (!categoryDao.isCategoryExistById(categoryId)) {
			logger.error("Category with id " + categoryId + " dosen't exist!");
			return "failure";
		}
		Category category = categoryDao.deleteCategoryByCategoryId(categoryId);
		return "Category \"" + category.getName() + "\" is deleted successfully";
	}

	@RequestMapping(value = "/category/add/{categoryJson}", method = RequestMethod.POST)
	public String addCategory(@PathVariable("categoryJson") String categoryJson) {
		ObjectMapper mapper = new ObjectMapper();
		Category category = null;
		try {
			category = mapper.readValue(categoryJson, Category.class);
		} catch (IOException e) {
			logger.error("categoryJson mapping error");
			logger.trace("Exception: ", e);
		}

		if (!categoryDao.isCategoryExistByName(category.getName())) {
			if (!categoryDao.isCategoryExistById(category.getId())) {
				Category savedCategory = categoryDao.saveCategory(category);
				logger.info("Saving success!");
				return "Category \"" + savedCategory.getName() + "\" with id = " + savedCategory.getId()
						+ " is saved successfully";
			} else {
				logger.info("Saving failure!");
				return "failure";
			}
		} else {
			logger.info("Saving failure!");
			return "failure";
		}
	}
	
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String addCategory(Category category) {
		
		if (!categoryDao.isCategoryExistByName(category.getName())) {
			if (!categoryDao.isCategoryExistById(category.getId())) {
				Category savedCategory = categoryDao.saveCategory(category);
				logger.info("Saving success!");
				return "Category \"" + savedCategory.getName() + "\" with id = " + savedCategory.getId()
						+ " is saved successfully";
			} else {
				logger.info("Saving failure!");
				return "failure";
			}
		} else {
			logger.info("Saving failure!");
			return "failure";
		}
	}

	@ExceptionHandler(TypeMismatchException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleTypeMismatchException(HttpServletRequest request, TypeMismatchException ex) {
		return "failure TypeMismatchException";
	}
}
