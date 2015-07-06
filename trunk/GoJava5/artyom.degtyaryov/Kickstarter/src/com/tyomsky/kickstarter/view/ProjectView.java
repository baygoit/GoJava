package com.tyomsky.kickstarter.view;

import com.tyomsky.kickstarter.model.Project;
import com.tyomsky.kickstarter.model.Entity;

public class ProjectView extends EntityView {

	public ProjectView(Entity entity) {
		super(entity);
		viewType = ViewTypes.Project;
	}

	@Override
    protected void prepareLayout() {
		Project project = (Project) entity;
		layout.add("Project: " + project.getName());
		layout.add("");
		layout.add("Money needed: " + project.getAmountNeeded());
		layout.add("Money collected: " + project.getAmountCollected());
		layout.add("");
		layout.add("Days left: " + project.getDaysLeft());
		layout.add("Project history: " + project.getHistory());
		layout.add("Video: " + project.getVideoURL());
		layout.add("FAQ: " + project.getQuestionsAndAnswers());
		layout.add("");
		layout.add("0) Exit");
		layout.add("");
	}

}
