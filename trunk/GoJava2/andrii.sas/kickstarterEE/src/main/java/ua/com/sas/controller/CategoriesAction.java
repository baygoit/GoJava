package ua.com.sas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import ua.com.sas.model.Category;
import ua.com.sas.service.ProjectsService;

public class CategoriesAction extends ActionSupport {

	@Autowired
	private ProjectsService service;

	private List<Category> categories;

	public String getAll() throws Exception {
		setCategories(service.getAll());
		return "success";
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
