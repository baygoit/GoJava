package ua.com.sas.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import ua.com.sas.model.Project;
import ua.com.sas.service.ProjectsService;

public class ProjectAction extends ActionSupport {
	
	private Project project;
	private int id;
	
	@Autowired
	private ProjectsService service;

	public String current(){
		setProject(service.getCurrent(id));
		return "success";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
