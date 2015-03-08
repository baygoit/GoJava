package ua.com.goit.gojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.com.goit.gojava.kickstarter.Category;
import ua.com.goit.gojava.kickstarter.Project;
import ua.com.goit.gojava.kickstarter.Quote;
import ua.com.goit.gojava.kickstarter.dao.CategoriesDAO;
import ua.com.goit.gojava.kickstarter.dao.ProjectsDAO;
import ua.com.goit.gojava.kickstarter.dao.QuotationsDao;

@Controller
public class MainController {

	@Autowired
	private QuotationsDao quotationsDao;

	@Autowired
	private CategoriesDAO categoriesDao;

	@Autowired
	private ProjectsDAO projectsDao;

	@RequestMapping("/categories")
	public ModelAndView showCategories() {

		List<Category> categories = categoriesDao.getAll();
		Quote quote = quotationsDao.getRandomQuote();
		ModelAndView mv = new ModelAndView("categories");
		mv.addObject("categories", categories);
		mv.addObject("quote", quote);
		return mv;
	}

	@RequestMapping("/projects")
	public ModelAndView showProjects(@RequestParam(value = "category") Integer categoryId) {

		List<Project> projects = projectsDao.getProjectsByCategoryId(categoryId);
		ModelAndView mv = new ModelAndView("projects");
		mv.addObject("projects", projects);
		return mv;
	}

	@RequestMapping("/project")
	public ModelAndView showSpecificProject(@RequestParam(value = "id", required = false) Integer projectId) {

		Project project = projectsDao.getProjectById(projectId);
		ModelAndView mv = new ModelAndView("project");
		mv.addObject("project", project);
		return mv;
	}

	@RequestMapping("/payment")
	public void payment(@RequestParam(value = "id") Integer projectId,
			@RequestParam(value = "inputAmount") Integer inputAmount) {

		Project project = projectsDao.getProjectById(projectId);
		project.addPayment(inputAmount);
		projectsDao.updateProject(projectId, "pledged", project.getPledged());
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
