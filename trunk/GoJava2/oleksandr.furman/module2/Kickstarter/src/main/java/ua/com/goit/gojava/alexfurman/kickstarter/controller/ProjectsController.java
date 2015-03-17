package ua.com.goit.gojava.alexfurman.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.goit.gojava.alexfurman.kickstarter.service.ProjectsService;

@Controller
public class ProjectsController {

	@Autowired
	private ProjectsService projectsService;

	@RequestMapping("/projects/{id}")
	public String projects(Model model, @PathVariable int id) {
		model.addAttribute("projects", projectsService.findByCategory(id));
		return "projects";
	}
	
	@RequestMapping("/project/{id}")
	public String project(Model model, @PathVariable int id) {
		model.addAttribute("project", projectsService.findOne(id));
		return "project";
	}
	
	@RequestMapping("/project/payment")
	public String payment(@RequestParam(value = "id") Integer projectId,
			@RequestParam(value = "inputAmount") Integer inputAmount) {
		projectsService.addPayment(projectsService.findOne(projectId), inputAmount);
		return "payment";
	}
}
