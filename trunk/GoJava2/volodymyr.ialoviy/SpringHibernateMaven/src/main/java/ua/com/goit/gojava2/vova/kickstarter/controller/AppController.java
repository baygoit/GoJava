package ua.com.goit.gojava2.vova.kickstarter.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.goit.gojava2.vova.kickstarter.model.Category;
import ua.com.goit.gojava2.vova.kickstarter.model.Quote;
import ua.com.goit.gojava2.vova.kickstarter.service.CategoryService;
import ua.com.goit.gojava2.vova.kickstarter.service.QuoteService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	QuoteService quoteService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listCategoriesWithQuote(ModelMap model, HttpServletRequest req) {
		Quote quote = quoteService.getQuote();
		model.addAttribute("quote", quote);
		return listOnlyCatgories(model, req);
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String listCategories(ModelMap model, HttpServletRequest req) {
		return listOnlyCatgories(model, req);
	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public String showCategory(ModelMap model, @PathVariable int id) {
		Category category = categoryService.getCategoryById(id);
		model.addAttribute("category", category);
		return "category";
	}

	@RequestMapping(value = "/categories/{id}", params = "delete", method = RequestMethod.GET)
	public String deleteCategory(ModelMap model, @PathVariable int id) {
		if (categoryService.getCategoryById(id).getProjects().isEmpty()){
			categoryService.deleteCategoryById(id);
			model.addAttribute("message", "Category successfully deleted");
		} else {
			model.addAttribute("message", "This category can not be removed because it is still not empty");
		}
		return "redirect:/categories";
	}
	
	@RequestMapping(value = "/categories", params = "add", method = RequestMethod.GET)
	public String newCategory(ModelMap model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "addcategory";
	}

	@RequestMapping(value = "/categories", params = "add", method = RequestMethod.POST)
	public String saveCategory(@Valid Category category, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "addcategory";
		}
		categoryService.saveCategory(category);
		model.addAttribute("message", "Category registered successfully");
		return "redirect:/categories";
	}

	private String listOnlyCatgories(ModelMap model, HttpServletRequest req) {
		List<Category> categories = categoryService.findAllCategories();
		model.addAttribute("message", req.getParameter("message"));
		model.addAttribute("categories", categories);
		return "categories";
	}
}
