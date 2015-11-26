package ua.com.goit.gojava7.kickstarter.Level;


import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class PaymentLevel implements Level {
	private QuestionDao questionDao;
	private RewardDao rewardDao;
	
	public PaymentLevel(QuestionDao questionDao, RewardDao rewardDao) {
		setQuestionDao(questionDao);
		setRewardDao(rewardDao);
	}

	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	
	public RewardDao getRewardDao() {
		return rewardDao;
	}

	public void setRewardDao(RewardDao rewardDao) {
		this.rewardDao = rewardDao;
	}
	
	public String generateAnswer(int userChoise, Category selectedCategory,
			Project selectedProject) {
		if (userChoise == 1) { // TODO
			return "";
		}

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("You selected 'to invest in the project'\n");

		int index = 1;
		for (Reward reward : rewardDao.getRewards(selectedProject.getId())) {
			stringBuilder.append(index++).append(" : Pledge $")
					.append(reward.getPledge()).append(" - get ")
					.append(reward.getBenefit()).append("\n");
		}
		stringBuilder.append(index).append(" : own amount\n");
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

		int rewardSize = rewardDao.size() + 1;
		if (userChoise < 0 || userChoise > rewardSize) {
			stringBuilder.append("Please, enter the number between 0 and ")
					.append(rewardSize);
		}
		return stringBuilder.toString();
	}

	public String fillOutForm(Project selectedProject, int userChoise,
			ConsoleScanner consoleScanner) {
		ConsolePrinter consolePrinter = new ConsolePrinter();

		if (userChoise == 2) {
			consolePrinter.print("Enter your question");
			String questionText = consoleScanner.scanLine();

			Question question = new Question();
			question.setProjectId(selectedProject.getId());
			question.setQuestionText(questionText);

			questionDao.addQuestion(question);

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
