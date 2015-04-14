package ua.com.goit.gojava.alexfurman.kickstarter.controller;

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

import ua.com.goit.gojava.alexfurman.kickstarter.entity.Project;
import ua.com.goit.gojava.alexfurman.kickstarter.service.CategoryService;
import ua.com.goit.gojava.alexfurman.kickstarter.service.ProjectsService;
import ua.com.goit.gojava.alexfurman.kickstarter.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectsService projectsService;

	@Autowired
	private CategoryService categoryService;
		
	@ModelAttribute("project")
	public Project constructProject() {
		return new Project();
	}

	@RequestMapping("/account")
	public String account(Model model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithProjects(name));
		model.addAttribute("projects", projectsService.findByUser(userService.findOneWithProjects(name)));
		model.addAttribute("categories", categoryService.getCategories());
		return "account";
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String doAddProject(Model model,
			@Valid @ModelAttribute("project") Project project, BindingResult result,
			Principal principal) {
		if (result.hasErrors()) {
			return account(model, principal);
		}
		String name = principal.getName();
		projectsService.save(project, name);
		return "redirect:/account.html";
	}
	
	@RequestMapping("/project/remove/{id}")
	public String removeProject(@PathVariable int id) {
		Project project = projectsService.findOne(id);
		projectsService.delete(project);
		return "redirect:/account.html";
	}

}
