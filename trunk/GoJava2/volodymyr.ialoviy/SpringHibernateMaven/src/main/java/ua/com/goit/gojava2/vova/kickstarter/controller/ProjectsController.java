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
import ua.com.goit.gojava2.vova.kickstarter.model.Project;
import ua.com.goit.gojava2.vova.kickstarter.model.Question;
import ua.com.goit.gojava2.vova.kickstarter.service.ProjectService;
import ua.com.goit.gojava2.vova.kickstarter.service.QuestionService;

@Controller
@RequestMapping("/")
public class ProjectsController {

	@Autowired
	ProjectService projectService;
	
	@Autowired
	QuestionService questionService;
	
	@RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
	public String listProjects(@PathVariable int id, ModelMap model, HttpServletRequest req) {
		List<Project> projects = projectService.findAllProjects(id);
		model.addAttribute("message", req.getParameter("message"));
		if(projects.isEmpty()){
			model.addAttribute("message", "This category does not have a project");
			return "redirect:/categories";
		} else {
			model.addAttribute("projects", projects);
			return "projects";
		}
	}
	
	@RequestMapping(value = "/projects/{id}", params = "show", method = RequestMethod.GET)
	public String showProject(@PathVariable int id, ModelMap model, HttpServletRequest req) {
		Project project = projectService.getProgect(id);
		List<Question> questions = questionService.findAllQuestions(project.getId());
		model.addAttribute("questions", questions);
		model.addAttribute("project", project);
		model.addAttribute("message", req.getParameter("message"));
		return "project";
	}

	@RequestMapping(value = "/projects/{id}/{idCategory}", params = "delete", method = RequestMethod.GET)
	public String deleteProject(ModelMap model, @PathVariable int id) {
		projectService.deleteProjectById(id);
		model.addAttribute("message", "Project successfully deleted");
		return "redirect:/projects/{idCategory}";
	}
	
	@RequestMapping(value = "/projects/{id}", params = "add", method = RequestMethod.GET)
	public String newProject(ModelMap model, @PathVariable int id) {
		Project project = new Project();
		model.addAttribute("id", id);
		model.addAttribute("project", project);
		return "addproject";
	}

	@RequestMapping(value = "/projects/{id}", params = "add", method = RequestMethod.POST)
	public String saveProject(@Valid Project project, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "addproject";
		}
		projectService.saveProject(project);
		model.addAttribute("message", "Project registered successfully");
		return "redirect:/categories";
	}
}
