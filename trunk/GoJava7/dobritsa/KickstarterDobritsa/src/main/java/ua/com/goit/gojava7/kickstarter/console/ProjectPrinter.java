package ua.com.goit.gojava7.kickstarter.console;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class ProjectPrinter {
	
	private String BORDER = "\n________________________________________________________";

	public void printProjects(List<Project> projects) {
		for (int i = 0; i < projects.size(); i++) {
			System.out.println("\n" + (i + 1) + ":");
			printShort(projects.get(i));
		}
	}

	public void printShort(Project project) {
		System.out.println("Name: \t\t" + project.getName());
		System.out.println("Description: \t" + project.getDescription());
		System.out.println("Goal: \t\t" + project.getGoal());
		System.out.println("Pledged: \t" + project.getPledged());
		System.out.println("Days to go: \t" + project.getDaysToGo());
	}

	public void printFull(Project project) {
		System.out.println(BORDER);
		printShort(project);
		System.out.println("History: \t" + project.getHistory());
		System.out.println("Demo video: \t" + project.getLink());	
	}

	public void printQuestions(List<Question> questions) {
		if (questions.size() == 0) {
			System.out.println("Questions: \tThere are no questions yet.");
			return;
		}
		for (int i = questions.size() - 1; i >= 0; i--) {
			System.out.println("\nData: " + questions.get(i).getTime() + "\nQuestion: " + questions.get(i).getQuestion()
					+ "\nAnswer: " + questions.get(i).getAnswer());
		}
	}

	public void printRewards(List<Reward> rewards) {
		if (rewards.size() == 0) {
			System.out.println("There are no rewards. You can just help the project.");
			System.out.println("\nType:");
			System.out.println("1: To choose amount of your pledge");
			System.out.println("0: To choose another project");
			return;
		}
		System.out.println("Type:");
		for (int i = 0; i < rewards.size(); i++) {
			System.out.println((i + 1) + ": \t$" + rewards.get(i).getAmount() + "\t-\t" + rewards.get(i).getReward());
		}
		System.out.println((rewards.size() + 1) + ":\tNo thanks, I just want to help the project."
				+ "\n0:\tTo choose another project");
	}

}
