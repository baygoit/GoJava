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
import org.springframework.web.bind.annotation.RequestParam;

import com.gojava2.kickstarter.entity.FAQ;
import com.gojava2.kickstarter.service.FaqService;
import com.gojava2.kickstarter.service.ProjectService;
import com.gojava2.kickstarter.service.ProjectStatusService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectsService;

	@Autowired
	private ProjectStatusService projectStatusService;

	@Autowired
	private FaqService faqService;

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

	@RequestMapping(value = "/project/payment", method = RequestMethod.POST)
	public String doPayment(@RequestParam(value = "id") Integer statusId,
			@RequestParam(value = "amount") Integer amount) {
		projectStatusService.invest(projectStatusService.get(statusId), amount);
		return "payment";
	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.POST)
	public String addFaq(Model model, @Valid @ModelAttribute("faq") FAQ faq,
			BindingResult result, Principal principal) {
		String name;
		if (principal == null) {
			name = "Guest";
		} else {
			name = principal.getName();
		}
		faqService.save(faq, name);
		return "redirect:/project/" + faq.getProject().getId() + ".html";
	}
}