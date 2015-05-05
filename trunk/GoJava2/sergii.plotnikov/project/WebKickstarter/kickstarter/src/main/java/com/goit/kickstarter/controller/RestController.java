package com.goit.kickstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.goit.kickstarter.dao.CategoryDAO;
import com.goit.kickstarter.dao.FaqDAO;
import com.goit.kickstarter.dao.ProjectDAO;
import com.goit.kickstarter.model.Category;
import com.goit.kickstarter.model.FAQ;
import com.goit.kickstarter.model.Project;

@Controller
public class RestController {

	@Autowired
	private CategoryDAO categoryDao;

	@Autowired
	private ProjectDAO projectDao;

	@Autowired
	private FaqDAO faqDao;

	@RequestMapping(value = "/")
	public String getMainPage() {
		return "index";
	}

	@RequestMapping(value = "/categories")
	public @ResponseBody List<Category> getCategories() {
		return categoryDao.getCategories();
	}

	@RequestMapping(value = "/categories/{id}")
	public @ResponseBody Category getCategory(@PathVariable int id) {
		return categoryDao.getCategory(id);
	}

	@RequestMapping(value = "/categories/{categoryId}/projects")
	public @ResponseBody List<Project> getProjects(@PathVariable int categoryId) {
		Category category = categoryDao.getCategory(categoryId);
		return projectDao.getProjects(category);
	}

	@RequestMapping(value = "/projects/{id}")
	public @ResponseBody Project getProject(@PathVariable int id) {
		return projectDao.getProject(id);
	}

	@RequestMapping(value = "/option/faq/{id}")
	public @ResponseBody List<FAQ> getFaqs(@PathVariable int id) {
		return faqDao.getFaq(id);
	}

	@RequestMapping(value = "/option/faq/{id}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void addFaq(@RequestBody FAQ faq, @PathVariable int id) {
		faq.setProjectId(id);
		faqDao.addFaq(faq);
	}
}
