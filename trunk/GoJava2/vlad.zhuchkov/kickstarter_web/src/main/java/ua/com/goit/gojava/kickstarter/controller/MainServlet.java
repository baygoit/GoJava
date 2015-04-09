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

@Controller
@RequestMapping("/")
public class MainServlet {

	@Autowired
	private CategoriesDao categoriesDao;
	@Autowired
	private ProjectsDao projectsDao;

	@RequestMapping(value = { "/", "/categories" }, method = RequestMethod.GET)
	public String getCategories(ModelMap model) {
		List<Category> categories = categoriesDao.getCatalog();
		model.addAttribute("categories", categories);
		return "catalog";
	}

	@RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
	public String getProjects(ModelMap model, @PathVariable int id) {
		List<Project> projects = projectsDao.getProjects(id);
		model.addAttribute("projects", projects);
		return "projects";
	}
	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public String getProject(ModelMap model, @PathVariable int id){
		Project project = projectsDao.get(id);
		model.addAttribute("project", project);
		return "project";
	}

	// } else if (request.startsWith("/projects")) {
	//
	//
	// req.setAttribute("projects", projects);
	//
	// req.getRequestDispatcher("/projects.jsp").forward(req, resp);
	// } else if (request.equals("/project")) {
	// int projectId = Integer.valueOf(req.getParameter("id"));
	//
	// Project project = projectsDao.get(projectId);
	//
	// req.setAttribute("project", project);
	//
	// req.getRequestDispatcher("/project.jsp").forward(req, resp);
	// }
	//
	// }

}
