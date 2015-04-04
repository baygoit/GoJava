package ua.com.sas.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import ua.com.sas.model.Project;
import ua.com.sas.service.ProjectsService;

public class ProjectAction implements ModelDriven {
	
	private Project project;
	private int id;
	
	@Autowired
	private ProjectsService projectsService;

	public String current(){
		setProject(projectsService.getCurrent(id));
		return "success";
	}
	
	@Override
	public Object getModel() {
		return getProject();
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
