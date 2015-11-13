package ua.com.goit.gojava7.kickstarter.console;

import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectPrinter {
	Project project;

	public ProjectPrinter(Project project) {
		this.project = project;

	}

	public void printShort() {
		System.out.println("Name: " + project.getName());
		System.out.println("Short description: " + project.getDescription());
		System.out.println("Goal: " + project.getGoal());
		System.out.println("Pledged: " + project.getPledged());
		System.out.println("Days to go: " + project.getDaysToGo());
	}

	public void printFull() {
		printShort();
		System.out.println("History: " + project.getHistory());
		System.out.println("Link to the demo video: " + project.getLink());
		System.out.println("Questions/Answers: " + project.getQuestions());
	}

}
