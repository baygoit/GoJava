package com.goit.kickstarter.glmax.pages;

import com.goit.kickstarter.glmax.enteties.Entetie;
import com.goit.kickstarter.glmax.enteties.Project;

public class ProjectPage extends Page {

	public ProjectPage(Entetie entetie) {
		super(entetie);
	}

	@Override
	protected void prepareFormatedPage() {
		Project project = (Project) entetie;
		formatedPage.add("You in project: " + project.getName());
		formatedPage.add("");
		formatedPage.add("Money needed: " + project.getAmountNeeded());
		formatedPage.add("Money Collected: " + project.getAmountCollected());
		formatedPage.add("");
		formatedPage.add("Days left: " + project.getDaysLeft());
		formatedPage.add("History: " + project.getHistory());
		formatedPage.add("Video URL: " + project.getVideoURL());
		formatedPage.add("QA's: " + project.getQuestionsAndAnswers());
		formatedPage.add("");
		formatedPage.add("1) Make a donation");
		formatedPage.add("2) Ask a question");
		formatedPage.add("0) Exit");
		formatedPage.add("");
	}

}
