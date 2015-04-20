package com.gojava2.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gojava2.kickstarter.service.ProjectService;

@Controller
public class ProjectsController {

	@Autowired
	private ProjectService projectsService;

	@RequestMapping("/projects/{id}")
	public String projects(Model model, @PathVariable int id) {
		model.addAttribute("projects", projectsService.getAll(id));
		return "projects";
	}

	@RequestMapping("/project/{id}")
	public String project(Model model, @PathVariable int id) {
		model.addAttribute("project", projectsService.get(id));
		return "project";
	}
}