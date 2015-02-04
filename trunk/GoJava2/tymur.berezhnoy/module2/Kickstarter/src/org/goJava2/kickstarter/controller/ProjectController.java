package org.goJava2.kickstarter.controller;

import java.util.List;
import java.util.Map;

import org.goJava2.kickstarter.behavior.ControllerBehavior;
import org.goJava2.kickstarter.content.Category;
import org.goJava2.kickstarter.content.Project;
import org.goJava2.kickstarter.factory.StorageFactory;
import org.goJava2.kickstarter.model.ProjectStorage;

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
		return projectStorage.getSpecificContent(t);
	}
}