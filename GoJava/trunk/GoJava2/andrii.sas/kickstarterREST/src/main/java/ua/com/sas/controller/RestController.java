package ua.com.sas.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.com.sas.model.Category;
import ua.com.sas.model.Faq;
import ua.com.sas.model.Project;
import ua.com.sas.model.Quote;
import ua.com.sas.service.FaqsService;
import ua.com.sas.service.ProjectsService;

@Controller
public class RestController {

	@Autowired
	private ProjectsService service;

	@Autowired
	private FaqsService serviceFaq;

	@RequestMapping(value = "/categories")
	public @ResponseBody List<Category> getAll() {
		return service.getAll();
	}

	@RequestMapping(value = "/quote")
	public @ResponseBody Quote get() {
		return service.getRandomed(new Random());
	}

	@RequestMapping(value = "/categories/{id}")
	public @ResponseBody List<Project> getProjects(@PathVariable int id) {
		return service.getWithProjects(id).getProjects();
	}

	@RequestMapping(value = "/project/{id}")
	public @ResponseBody Project getProject(@PathVariable int id) {
		return service.getCurrent(id);
	}

	@RequestMapping(value = "/faq/{id}")
	public @ResponseBody List<Faq> getFaqs(@PathVariable int id) {
		return serviceFaq.getFaqs(id);
	}

	@RequestMapping(value = "faq/{id}", method = RequestMethod.POST)
	public void post(@RequestBody final Faq faq, @PathVariable int id) {
		serviceFaq.addQuestion(faq, id);
	}

}
