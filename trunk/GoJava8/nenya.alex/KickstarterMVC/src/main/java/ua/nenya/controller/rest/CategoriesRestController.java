package ua.nenya.controller.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ua.nenya.controller.jsp.CategoryController;
import ua.nenya.dao.CategoryDao;
import ua.nenya.domain.Category;

@RestController
@RequestMapping("/rest")
public class CategoriesRestController {

	@Autowired
	private CategoryDao categoryDao;

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@RequestMapping(value = "/category", method = RequestMethod.GET)
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

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.DELETE)
	public String deleteCategory(@PathVariable("categoryId") Long categoryId) {
		if (!categoryDao.isCategoryExistById(categoryId)) {
			logger.error("Category with id " + categoryId + " dosen't exist!");
			return "failure";
		}
		Category category = categoryDao.deleteCategoryByCategoryId(categoryId);
		return "Category \"" + category.getName() + "\" is deleted successfully";
	}
	
	@RequestMapping(value = "/category", consumes = "application/json", method = RequestMethod.POST)
	public Category addCategory(@RequestBody Category category) {

		if (categoryDao.isCategoryExistByName(category.getName())) {
			logger.info("Saving failure!");
			return new Category();
		}
	    return categoryDao.saveCategory(category);
	}

	@ExceptionHandler(TypeMismatchException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleTypeMismatchException(HttpServletRequest request, TypeMismatchException ex) {
		return "failure TypeMismatchException";
	}
}
