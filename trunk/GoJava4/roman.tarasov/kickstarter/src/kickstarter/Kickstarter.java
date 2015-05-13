package kickstarter;

import kickstarter.Entities.Category;
import kickstarter.Entities.Comments;
import kickstarter.Entities.Project;
import kickstarter.Entities.Quote;
import kickstarter.Repository.Storage;

public class Kickstarter {

	Storage<Category> categories;
	Storage<Project> projects;
	UserInterface ui;
	Storage<Quote> quotes;
	Storage<Comments> allComments;

	public void start() {
		ui = new ConsoleUI();
		PageDispatcher dispatcher = new PageDispatcher(ui, categories,
				projects, quotes,allComments);
		dispatcher.startDispatcher();
	}

	public void addCategories(Storage<Category> categories) {
		this.categories = categories;
	}

	public void addProjects(Storage<Project> projects) {
		this.projects = projects;
	}

	public void addQuotes(Storage<Quote> quotes) {
		this.quotes = quotes;

	}

	public void addAllComments(Storage<Comments> allComments) {
		this.allComments = allComments;

	}
}
