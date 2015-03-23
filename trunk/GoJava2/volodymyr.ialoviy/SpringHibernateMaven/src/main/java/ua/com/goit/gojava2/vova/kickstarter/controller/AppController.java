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
import ua.com.goit.gojava2.vova.kickstarter.model.Project;
import ua.com.goit.gojava2.vova.kickstarter.service.CategoryService;
import ua.com.goit.gojava2.vova.kickstarter.service.ProjectService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProjectService projectService;

	@RequestMapping(value = { "/", "/categories" }, method = RequestMethod.GET)
	public String listCategories(ModelMap model) {

		List<Category> categories = categoryService.findAllCategories();
		model.addAttribute("categories", categories);
		return "categories";
	}
	
	@RequestMapping(value = { "/projects" }, method = RequestMethod.GET)
	public String listProjects(HttpServletRequest req, ModelMap model) {
		int idCategory = Integer.valueOf(req.getParameter("category"));
		
		List<Project> projects = projectService.findAllProjects(idCategory);
		model.addAttribute("projects", projects);
		return "projects";
	}

	@RequestMapping(value = { "/newcategory" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "addcategory";
	}

	@RequestMapping(value = { "/newcategory" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid Category category, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "addcategory";
		}

		categoryService.saveCategory(category);

		model.addAttribute("success", "Category " + category.getName()
				+ " registered successfully");
		return "success";
	}

	@RequestMapping(value = { "/delete-{id}-category" }, method = RequestMethod.GET)
	public String deleteCategory(@PathVariable Integer idCategory) {
		categoryService.deleteCategoryById(idCategory);
		return "redirect:/categories";
	}
	
	@RequestMapping(value = { "/delete-{id}-project" }, method = RequestMethod.GET)
	public String deleteProject(@PathVariable Integer idProject) {
		projectService.deleteProjectById(idProject);
		return "redirect:/projects";
	}

}
