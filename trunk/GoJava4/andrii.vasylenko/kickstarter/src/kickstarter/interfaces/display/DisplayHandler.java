package kickstarter.interfaces.display;

import kickstarter.engine.Category;
import kickstarter.engine.Project;
import kickstarter.engine.Quote;

public class DisplayHandler {
	public Display<Quote> getQuoteDisplay() {
		return new QuoteDisplay();
	}

	public Display<Category> getCategoryDisplay() {
		return new CategoryDisplay();
	}

	public Display<Project> getProjectDisplay() {
		return new ProjectDisplay();
	}

	public Display<Project> getProjectDetailDisplay() {
		return new ProjectDetailDisplay();
	}
}
