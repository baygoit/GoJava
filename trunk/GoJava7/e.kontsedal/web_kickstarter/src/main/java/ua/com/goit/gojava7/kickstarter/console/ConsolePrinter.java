package ua.com.goit.gojava7.kickstarter.console;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractCategoryStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractPaymentStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractProjectStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractQuestionStorage;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Question;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class ConsolePrinter {
	private static final String N = "\n";
	private static final String SEPARATOR = "========================";

	public void println(String string) {
		System.out.println(string);
	}

	public void println(Quote quote) {
		System.out.println(SEPARATOR + N + quote.getText() + N + "(c)" + quote.getAuthor() + N + SEPARATOR);
	}

	public void println(Category category) {
		System.out.println(SEPARATOR + N + category.getCategoryName() + N + SEPARATOR);
	}

	public void println(AbstractCategoryStorage categoryStorage) {
		int i = 0;
		System.out.println(SEPARATOR);
		for (Category category : categoryStorage.getAll()) {
			System.out.println(++i + ":" + category.getCategoryName());
		}
		System.out.println(SEPARATOR);
	}

	public void println(AbstractProjectStorage projectStorage, int idOfCategory, AbstractPaymentStorage paymentStorage) {
		List<Project> projects = projectStorage.getProjectsFromSelectedCategory(idOfCategory);
		int i = 0;
		for (Project project : projects) {
			String name = project.getProjectName();
			String shortDescription = project.getProjectShortDescription();
			int costNeed = project.getProjectCostNeed();
			int daysLeft = project.getProjectDaysLeft();
			
			System.out.println
					(++i + ":" 		
					+ name + N
					+ shortDescription + N
					+ "Days left:" +daysLeft + N
					+ "Costs need:" + costNeed + N
					+ "Costs collected:" + paymentStorage.getSummaryProjectCostsCollected(project.getIdProject()));
		}
		
	}

	public void println(Project project, AbstractPaymentStorage paymentStorage, AbstractQuestionStorage questionStorage) {
		System.out.println(
				"Name: " + project.getProjectName() + N
				+ "Description: " + project.getProjectDescription() + N
				+ "Days left: " + project.getProjectDaysLeft() + N 
				+ "Video: " + project.getVideoUrl() + N
				+ "Need costs: " + project.getProjectCostNeed() + N
				+ "Need collected: " + paymentStorage.getSummaryProjectCostsCollected(project.getIdProject())
				);

		for (Question question : questionStorage.getAll()) {
			System.out.println(question.getQuestion());
		}
	}
}
