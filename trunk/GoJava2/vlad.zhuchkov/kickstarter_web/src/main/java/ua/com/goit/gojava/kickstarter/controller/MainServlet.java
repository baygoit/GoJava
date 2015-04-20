package ua.com.goit.gojava.kickstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		model.addAttribute("id", id);
		return "projects";
	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public String getProject(ModelMap model, @PathVariable int id) {
		Project project = projectsDao.get(id);
		model.addAttribute("project", project);
		return "project";
	}
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	   public ModelAndView category() {
		return new ModelAndView("newCategory", "command", new Category());
	}
	
	@RequestMapping(value = "/newCategory", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("SpringWeb")Category category){
		categoriesDao.add(category);
		return "redirect:categories" ;
	}
	@RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.GET)
	public String deleteCategories(@PathVariable int id) {
		categoriesDao.delete(id);
		return "redirect:/categories";
	}

}
