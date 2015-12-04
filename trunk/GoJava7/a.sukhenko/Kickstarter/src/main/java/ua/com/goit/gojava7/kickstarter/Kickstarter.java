package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.Menu;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuestionStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.domain.User;

public class Kickstarter{

	private QuoteStorage	quoteStorage;
	private CategoryStorage	categoryStorage;
	private Body			body;
	private ProjectStorage	projectStorage;
	private QuestionStorage	questionStorage;
	public Kickstarter(QuoteStorage quoteStorage, CategoryStorage categoryStorage, Body body,
			ProjectStorage projectStorage, QuestionStorage questionStorage) {
		super();
		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
		this.body = body;
		this.projectStorage = projectStorage;
		this.setQuestionStorage(questionStorage);
	}

	public QuoteStorage getQuoteStorage() {
		return quoteStorage;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public CategoryStorage getCategoryStorage() {
		return categoryStorage;
	}

	public void setCategoryStorage(CategoryStorage categoryStorage) {
		this.categoryStorage = categoryStorage;
	}

	public ProjectStorage getProjectManager() {
		return projectStorage;
	}

	public void setProjectManager(ProjectStorage projectManager) {
		this.projectStorage = projectManager;
	}

	public void run() {
		User user = new User();
		body.generateMainPage(quoteStorage, projectStorage, categoryStorage);
		Menu menu = new Menu(user, projectStorage, categoryStorage);
		menu.showMenu();

	}

	public void shutdown() {
		// TODO Auto-generated method stub

	}

	public QuestionStorage getQuestionStorage() {
		return questionStorage;
	}

	public void setQuestionStorage(QuestionStorage questionStorage) {
		this.questionStorage = questionStorage;
	}

}
