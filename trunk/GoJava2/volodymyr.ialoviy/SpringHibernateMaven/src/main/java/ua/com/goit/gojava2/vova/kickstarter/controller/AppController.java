package ua.com.goit.gojava2.vova.kickstarter.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String listCategories(ModelMap model) {
		List<Category> categories = categoryService.findAllCategories();

		if(categories.isEmpty()) {
			model.addAttribute("projects", new ArrayList<Project>());
		}
		else{
			model.addAttribute("projects", categories.get(0).getProjects());
		}

		model.addAttribute("categories", categories);
		return "categories";
	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public String listCategoriesAndProjects(ModelMap model, @PathVariable int id) {

		List<Category> categories = categoryService.findAllCategories();

		List<Project> projects = categoryService.getCategoryById(id)
				.getProjects();
		model.addAttribute("projects", projects);

		model.addAttribute("categories", categories);
		return "categories";
	}

	@RequestMapping(value = "/categories/{id}", params = "delete", method = RequestMethod.GET)
	public String deleteCategory(ModelMap model, @PathVariable int id) {
		categoryService.deleteCategoryById(id);
		return "redirect:/categories";
	}

	@RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
	public @ResponseBody String listProjectsPost(@PathVariable int id,
			ModelMap model) {
		Project project = projectService.getProgect(id);
		model.addAttribute("project", project);
		return "project";
	}

	@RequestMapping(value = "/projects/{id}", params = "delete", method = RequestMethod.GET)
	public String deleteProject(ModelMap model, @PathVariable int id) {
		projectService.deleteProjectById(id);
		return "redirect:/categories";
	}

	@RequestMapping(value = "/donate", method = RequestMethod.GET)
	public String donate(ModelMap model, HttpServletRequest req) {
		Integer idproject = Integer.valueOf(req.getParameter("idproject"));
		model.addAttribute("idproject", idproject);
		return "donate";
	}

	@RequestMapping(value = "/donatesuccess", method = RequestMethod.GET)
	public String saveDonate(ModelMap model, HttpServletRequest req) {
		Integer amount = Integer.valueOf(req.getParameter("amount"));
		Integer project = Integer.valueOf(req.getParameter("project"));
		projectService.addDonate(amount, project);

		model.addAttribute("success", "Donate " + amount + " successfully");
		model.addAttribute("project", project);
		return "donatesuccess";
	}

	@RequestMapping(value = "/newcategory", method = RequestMethod.GET)
	public String newCategory(ModelMap model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "addcategory";
	}

	@RequestMapping(value = "/newcategory", method = RequestMethod.POST)
	public String saveCategory(@Valid Category category, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "addcategory";
		}

		categoryService.saveCategory(category);

		model.addAttribute("success", "Category " + category.getName()
				+ " registered successfully");
		return "success";
	}
}
