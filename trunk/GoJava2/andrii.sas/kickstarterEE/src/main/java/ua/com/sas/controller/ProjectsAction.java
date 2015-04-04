package ua.com.sas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import ua.com.sas.dao.CategoriesDAO;
import ua.com.sas.model.Category;
import ua.com.sas.model.Project;
import ua.com.sas.service.CategoriesService;

public class ProjectsAction implements ModelDriven {

	private Project project;
	private int id;
	private List<Project> projects;
	
	@Autowired
	private CategoriesService categoriesService;

	public String findProjects() throws Exception {
		Category category = categoriesService.getWithProjects(id);
		setProjects(category.getProjects());
		return "success";
	}
	
	@Override
	public Object getModel() {
		return getProject();
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
