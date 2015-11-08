package kickstarter.interfaces;

import java.util.Iterator;

import kickstarter.engine.Category;
import kickstarter.engine.Project;
import kickstarter.engine.Quote;
import kickstarter.interfaces.display.Display;

public class Preparer {
	private Display<Quote> quotesDisplay;
	private Display<Category> categoriesDisplay;
	private Display<Project> projectsDisplay;
	private Display<Project> projectDisplay;

	public Preparer(Display<Quote> quotesDisplay, Display<Category> categoriesDisplay,
			Display<Project> projectsDisplay, Display<Project> projectDisplay) {
		this.quotesDisplay = quotesDisplay;
		this.categoriesDisplay = categoriesDisplay;
		this.projectsDisplay = projectsDisplay;
		this.projectDisplay = projectDisplay;
	}

	public String getQuoteView(Quote quote) {
		return quotesDisplay.getView(quote);
	}

	public String getCategoriesView(Iterator<Category> categories) {
		return categoriesDisplay.getView(categories);
	}

	public String getProjectsView(Iterator<Project> projects) {
		return projectsDisplay.getView(projects);
	}

	public String getProjectView(Project project) {
		return projectDisplay.getView(project);
	}

}
