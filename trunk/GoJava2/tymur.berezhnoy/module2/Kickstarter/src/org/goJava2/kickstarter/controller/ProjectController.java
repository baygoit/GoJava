package org.goJava2.kickstarter.controller;

import java.util.List;
import java.util.Map;

import org.goJava2.kickstarter.behavior.ControllerBehavior;
import org.goJava2.kickstarter.content.Category;
import org.goJava2.kickstarter.content.Project;
import org.goJava2.kickstarter.factory.StorageFactory;

public class ProjectController implements ControllerBehavior<Category> {
	
	@Override
	public Map<Category, List<Project>> passContentToView() {
		return StorageFactory.getProjectStorage().getContent();
	}
	
	@Override
	public List<Project> passSpecificContentToView(Category t) {
		return StorageFactory.getProjectStorage().getSpecificContent(t);
	}
}