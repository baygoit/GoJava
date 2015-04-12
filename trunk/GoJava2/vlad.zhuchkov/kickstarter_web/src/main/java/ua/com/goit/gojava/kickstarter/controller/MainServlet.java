package ua.com.goit.gojava.kickstarter.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.goit.gojava.kickstarter.dao.CategoriesDao;
import ua.com.goit.gojava.kickstarter.dao.ProjectsDao;
import ua.com.goit.gojava.kickstarter.data.Category;
import ua.com.goit.gojava.kickstarter.data.Project;
import ua.com.goit.gojava.kickstarter.data.Quote;
import ua.com.goit.gojava.kickstarter.data.Quotes;

@Controller
@RequestMapping("/")
public class MainServlet {

	@Autowired
	private CategoriesDao categoriesDao;
	@Autowired
	private ProjectsDao projectsDao;
	@Autowired
	private Quotes quoteDao;

	@RequestMapping(value = { "/", "/categories" }, method = RequestMethod.GET)
	public String getCategories(ModelMap model) {
		List<Category> categories = categoriesDao.getCatalog();
		Quote quote = quoteDao.getRandomQuote();
		model.addAttribute("categories", categories);
		model.addAttribute("quote", quote);
		return "catalog";
	}

	@RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
	public String getProjects(ModelMap model, @PathVariable int id) {
		List<Project> projects = projectsDao.getProjects(id);
		model.addAttribute("projects", projects);
		return "projects";
	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public String getProject(ModelMap model, @PathVariable int id) {
		Project project = projectsDao.get(id);
		model.addAttribute("project", project);
		return "project";
	}
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public void addCategory(ModelMap model, @PathVariable int id) {
		
	}
	

}
