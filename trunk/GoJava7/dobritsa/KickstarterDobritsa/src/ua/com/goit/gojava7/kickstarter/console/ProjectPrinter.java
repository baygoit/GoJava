package ua.com.goit.gojava7.kickstarter.console;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class ProjectPrinter {
	public void printShort(Project project) {
		System.out.println("Name: " + project.getName());
		System.out.println("Short description: " + project.getDescription());
		System.out.println("Goal: " + project.getGoal());
		System.out.println("Pledged: " + project.getPledged());
		System.out.println("Days to go: " + project.getDaysToGo());
	}

	public void printFull(Project project) {
		printShort(project);
		System.out.println("History: " + project.getHistory());
		System.out.println("Link to the demo video: " + project.getLink());
		printQuestions(project.getQuestions());
	}
	
	public void printQuestions(List<Question> questions) {
		for (int i = questions.size() - 1; i >= 0; i--) {
			System.out.println(
					"Question: " + questions.get(i).getQuestion() + "\n\tAnswer: " + questions.get(i).getAnswear());
		}
	}

}
