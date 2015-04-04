package ua.com.sas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import ua.com.sas.model.Category;
import ua.com.sas.model.Project;
import ua.com.sas.service.ProjectsService;

public class ProjectsAction extends ActionSupport {

	private Project project;
	private int id;
	private List<Project> projects;

	@Autowired
	private ProjectsService service;

	public String findProjects() throws Exception {
		Category category = service.getWithProjects(id);
		projects = category.getProjects();
		return "success";
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
