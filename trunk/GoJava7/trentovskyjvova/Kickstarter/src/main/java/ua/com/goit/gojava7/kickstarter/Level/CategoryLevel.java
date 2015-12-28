package ua.com.goit.gojava7.kickstarter.Level;

import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class CategoryLevel implements Level {
	private ProjectDao projectDao;
	private PaymentDao paymentDao;
	
	public CategoryLevel(ProjectDao projectDao, PaymentDao paymentDao) {
		setProjectDao(projectDao);
		setPaymentDao(paymentDao);
	}

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
	
	public PaymentDao getPaymentDao() {
		return paymentDao;
	}

	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}
	
	public String generateAnswer(int userChoise, Category selectedCategory,
			Project selectedProject) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("You selected '")
				.append(selectedCategory.getName()).append("' category")
				.append("\n");

		String format = "%-3s|%-20s|%10s|%10s|%10s%n";
		stringBuilder.append(String.format(format, "", "name", "funded",
				"days to go", "pledged"));
		
		int index = 1;
		for (Project project : projectDao.getProjects(selectedCategory.getId())) {	
			int pledged = paymentDao.getPledged(project.getId());
			
			stringBuilder.append(String.format(format, index++,
					project.getName(), project.getFunded(),
					project.getDaysToGo(), pledged));
		}
		
		stringBuilder.append("0 : main menu").append("\n");
		stringBuilder.append("Select a project");

		return stringBuilder.toString();
	}

	public Category findSelectedCategory(int userChoise,
			Category selectedCategory) {

		return selectedCategory;
	}

	public String validateUserChoise(int userChoise, Category selectedCategory,
			Project selectedProject) {
		StringBuilder stringBuilder = new StringBuilder();
		
		int projectsSize = projectDao.size(selectedCategory.getId());
		if (userChoise < 0 || userChoise > projectsSize) {
			stringBuilder.append("Please, enter the number between 0 and ")
					.append(projectsSize);
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

		selectedProject = projectDao.getProject(userChoise, selectedCategory.getId());

		return selectedProject;
	}

}
