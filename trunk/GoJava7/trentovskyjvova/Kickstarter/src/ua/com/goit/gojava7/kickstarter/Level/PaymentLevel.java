package ua.com.goit.gojava7.kickstarter.Level;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Reward;
import ua.com.goit.gojava7.kickstarter.storage.PaymentStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuestionStorage;

public class PaymentLevel implements Level {

	public String generateAnswer(List<Category> categories, int userChoise,
			Category selectedCategory, Project selectedProject) {
		if (userChoise == 1) { // TODO 
			return "";
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("You selected 'to invest in the project'\n");
		
		int index = 1;
		for (Reward reward : selectedProject.getRewards()) {
			stringBuilder.append(index++).append(" : Pledge $")
					.append(reward.getPledge()).append(" - get ")
					.append(reward.getBenefit()).append("\n");
		}
		stringBuilder.append(index).append(" : own amount\n");
		stringBuilder.append("0 : to project list");
		return stringBuilder.toString();
	}

	public Category findSelectedCategory(List<Category> categories,
			int userChoise, Category selectedCategory) {
		return selectedCategory;
	}

	public String validateUserChoise(List<Category> categories, int userChoise,
			Category selectedCategory, Project selectedProject) {
		
		StringBuilder stringBuilder = new StringBuilder();

		if (userChoise < 0 || userChoise > selectedProject.rewardsSize()+1) {
			stringBuilder.append("Please, enter the number between 0 and ")
					.append(selectedProject.rewardsSize()+1);
		}
		return stringBuilder.toString();
	}

	public String fillOutForm(Project project, int userChoise,
			ConsoleScanner consoleScanner, QuestionStorage questionStorage,
			PaymentStorage paymentStorage) {
		ConsolePrinter consolePrinter = new ConsolePrinter();

		if (userChoise == 2) {
			consolePrinter.print("Enter your question");
			String questionText = consoleScanner.scanLine();
			
			Question question = new Question(questionStorage.generateIdOfNewElement());
			question.setProjectId(project.getId());
			question.setQuestionText(questionText);
			
			project.addQuestion(question);
			questionStorage.addQuestion(question);
			
			return "Thank for your question!\n0 : back to project";
		} else {
			return "";
		}
	}

	public Project findSelectedProject(int userChoise,
			Category selectedCategory, Project selectedProject) {

		return selectedProject;
	}

}
