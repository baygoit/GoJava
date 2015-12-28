package ua.com.goit.gojava7.kickstarter.Level;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class ProjectLevel implements Level {
	private PaymentDao paymentDao;
	private QuestionDao questionDao;

	public ProjectLevel(PaymentDao paymentDao, QuestionDao questionDao) {
		setPaymentDao(paymentDao);
		setQuestionDao(questionDao);
	}

	public PaymentDao getPaymentDao() {
		return paymentDao;
	}

	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	public String generateAnswer(int userChoise, Category selectedCategory,
			Project selectedProject) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("You selected '")
				.append(selectedProject.getName()).append("' project")
				.append("\n");

		int pledged = paymentDao.getPledged(selectedProject.getId());
		
		stringBuilder.append("name: ").append(selectedProject.getName()).append("\n");
		stringBuilder.append("funded: ").append(selectedProject.getFunded()).append("\n");
		stringBuilder.append("daysToGo: ").append(selectedProject.getDaysToGo()).append("\n");
		stringBuilder.append("pledged: ").append(pledged).append("\n");
		stringBuilder.append("description: ").append(selectedProject.getDescription()).append("\n");
		stringBuilder.append("owner: ").append(selectedProject.getOwner()).append("\n");
		stringBuilder.append("goal: ").append(selectedProject.getGoal()).append("\n");
		stringBuilder.append("linkVideo: ").append(selectedProject.getLinkVideo()).append("\n");

		List<Question> questions = questionDao.getQuestions(selectedProject
				.getId());
		for (Question question : questions) {
			stringBuilder.append("Question: '")
					.append(question.getQuestionText()).append("'\n");
		}

		stringBuilder.append("1 : to invest in the project").append("\n");
		stringBuilder.append("2 : to ask a question").append("\n");
		stringBuilder.append("0 : to project list");
		return stringBuilder.toString();
	}

	public Category findSelectedCategory(int userChoise,
			Category selectedCategory) {
		return selectedCategory;
	}

	public String validateUserChoise(int userChoise, Category selectedCategory,
			Project selectedProject) {
		StringBuilder stringBuilder = new StringBuilder();

		if (userChoise < 0 || userChoise > 2) {
			stringBuilder.append("Please, enter the correct number");
		}
		return stringBuilder.toString();
	}

	@Override
	public String fillOutForm(Project project, int userChoise,
			ConsoleScanner consoleScanner) {

		return "";
	}

	public Project findSelectedProject(int userChoise,
			Category selectedCategory, Project selectedProject) {

		return selectedProject;
	}

}
