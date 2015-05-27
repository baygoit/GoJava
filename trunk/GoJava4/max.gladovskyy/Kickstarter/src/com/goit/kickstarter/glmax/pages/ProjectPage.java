package com.goit.kickstarter.glmax.pages;

import java.util.ArrayList;

import com.goit.kickstarter.glmax.controller.Kickstarter;
import com.goit.kickstarter.glmax.enteties.Project;
import com.goit.kickstarter.glmax.model.DataSource;

public class ProjectPage implements Page {
	private DataSource dataSource = Kickstarter.getDataSource();
	private ArrayList<String> page = new ArrayList<String>();
	private Project project;

	
	
	public ProjectPage(int category, int project) {
		this.project = dataSource.getProject(category, project);
	}

	@Override
	public ArrayList<String> getPage() {
		page.add("You in project: " + project.getName());
		page.add("");
		page.add("Money needed: " + project.getAmountNeeded());
		page.add("Money Collected: " + project.getAmountCollected());
		page.add("Days left: " + project.getDaysLeft());
		page.add("History: " + project.getHistory());
		page.add("Video URL: " + project.getVideoURL());
		page.add("QA's: " + project.getQuestionsAndAnswers());
		page.add("");
		page.add("0) Exit");
		return page;
	}

}
