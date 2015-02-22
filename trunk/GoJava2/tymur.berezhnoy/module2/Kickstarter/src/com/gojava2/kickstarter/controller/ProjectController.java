package com.gojava2.kickstarter.controller;

import java.util.List;
import java.util.Map;

import com.gojava2.kickstarter.behavior.ControllerBehavior;
import com.gojava2.kickstarter.content.Category;
import com.gojava2.kickstarter.content.Project;
import com.gojava2.kickstarter.factory.StorageFactory;
import com.gojava2.kickstarter.model.ProjectStorage;

public class ProjectController implements ControllerBehavior<Category> {
	
	private ProjectStorage projectStorage;
	
	public ProjectController() {
		projectStorage = new StorageFactory().getProjectStorage();
	}
	
	@Override
	public Map<Category, List<Project>> getContent() {
		return projectStorage.getContent();
	}
	
	@Override
	public List<Project> getSpecificContent(Category t) {
		return projectStorage.getContent().get(t);
	}
}