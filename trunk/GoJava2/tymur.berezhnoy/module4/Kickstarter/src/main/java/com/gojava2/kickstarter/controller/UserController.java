package com.gojava2.kickstarter.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gojava2.kickstarter.entity.Project;
import com.gojava2.kickstarter.entity.ProjectStatus;
import com.gojava2.kickstarter.service.CategoryService;
import com.gojava2.kickstarter.service.ProjectService;
import com.gojava2.kickstarter.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private CategoryService categoryService;

	@ModelAttribute("project")
	public Project constructProject() {
		return new Project();
	}

	@ModelAttribute("projectStatus")
	public ProjectStatus constructProjectStatus() {
		return new ProjectStatus();
	}

	@RequestMapping("/user/{name}")
	public String getUser(Model model, @PathVariable String name) {
		model.addAttribute("user", userService.getUser(name));
		return "user";
	}

	@RequestMapping("/account-manage")
	public String account(Model model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("user", userService.getUser(name));
		model.addAttribute("categories", categoryService.getCategories());
		return "account-manage";
	}

	@RequestMapping(value = "/account-manage", method = RequestMethod.POST)
	public String addProject(Model model, @Valid @ModelAttribute("project") Project project, BindingResult result,  
			@Valid @ModelAttribute("projectStatus") ProjectStatus projectStatus,
			Principal principal) {
		if (result.hasErrors()) {
			return account(model, principal);
		}
		String userName = principal.getName();
		projectService.save(project, projectStatus, userName);
		return "redirect:/account-manage.html";
	}
	
	@RequestMapping("/project/remove/{id}")
	private String removeProject(@PathVariable int id) {
		Project project = projectService.get(id);
		projectService.delet(project);
		return "redirect:/account-manage.html";
	}
}