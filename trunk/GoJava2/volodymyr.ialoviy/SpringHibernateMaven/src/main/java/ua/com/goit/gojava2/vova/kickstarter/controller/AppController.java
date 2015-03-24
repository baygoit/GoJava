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
		model.addAttribute("category", idCategory);
		return "projects";
	}
	
	@RequestMapping(value = { "/project" }, method = RequestMethod.GET)
	public String Project(HttpServletRequest req, ModelMap model) {
		Integer idProject = Integer.valueOf(req.getParameter("project"));
		Project project = projectService.getProgect(idProject);
		model.addAttribute("project", project);
		return "project";
	}
	
	@RequestMapping(value = { "/donate" }, method = RequestMethod.GET)
	public String donate(ModelMap model, HttpServletRequest req) {
		Integer idproject = Integer.valueOf(req.getParameter("idproject"));
		model.addAttribute("idproject", idproject);
		return "donate";
	}
	
	@RequestMapping(value = { "/donatesuccess" }, method = RequestMethod.GET)
	public String saveDonate(ModelMap model, HttpServletRequest req) {
		Integer amount = Integer.valueOf(req.getParameter("amount"));
		Integer project = Integer.valueOf(req.getParameter("project"));
		projectService.addDonate(amount, project);

		model.addAttribute("success", "Donate " + amount + " successfully");
		return "donatesuccess";
	}

	@RequestMapping(value = { "/newcategory" }, method = RequestMethod.GET)
	public String newCategory(ModelMap model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "addcategory";
	}

	@RequestMapping(value = { "/newcategory" }, method = RequestMethod.POST)
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

	@RequestMapping(value = { "/delete-{idCategory}-category" }, method = RequestMethod.GET)
	public String deleteCategory(@PathVariable Integer idCategory) {
		categoryService.deleteCategoryById(idCategory);
		return "redirect:/categories";
	}
	
	@RequestMapping(value = { "/delete-{idProject}-project-{idCategory}" }, method = RequestMethod.GET)
	public String deleteProject(@PathVariable Integer idProject, @PathVariable String idCategory) {
		projectService.deleteProjectById(idProject);
		return "redirect:/projects?category=" + idCategory;
	}

}
