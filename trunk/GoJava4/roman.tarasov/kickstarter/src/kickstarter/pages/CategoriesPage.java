package kickstarter.pages;

import kickstarter.entities.Quote;
import kickstarter.repository.CategoriesRepository;
import kickstarter.repository.QuotesRepository;

import kickstarter.ui.UserInterface;

public class CategoriesPage extends Page {

	// private Storage<Quote> quotes;
	private UserInterface ui;
	final int ERROR_PAGE = 3;
	final int PROJECTS = 1;
	QuotesRepository quotesRepository;
	CategoriesRepository categories;

	public CategoriesPage(CategoriesRepository categories, UserInterface ui,
			QuotesRepository quotesRepository) {
		this.categories = categories;
		this.quotesRepository = quotesRepository;
		this.ui = ui;
	}

	public void print() {
		Quote randomQuote = quotesRepository.getRandomQuote();
		ui.display("-----Quote------");
		ui.display(randomQuote.getQuote());
		ui.display("----------------");

		ui.display("=========================");
		ui.display("|     Categories        |");
		ui.display("=========================");
		String list = categories.getListAllCategories();
		ui.display(list);

		ui.display("------------------------");
	}

	public String[] getOptions() {
		return options;
	}

	public void execute(String message) {
		options = categories.getStringOptions();
		optionsInt = categories.getIntOptions();
		if (options != null) {
			for (int index = 0; index < options.length; index++) {
				if (message.equals(options[index])) {
					nextPage = PROJECTS;
					parameterForPrint = optionsInt[index];
					return;
				}
			}
		}
		nextPage = ERROR_PAGE;
	}
}