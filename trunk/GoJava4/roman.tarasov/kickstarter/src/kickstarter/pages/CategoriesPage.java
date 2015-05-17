package kickstarter.pages;

import kickstarter.entities.Quote;
import kickstarter.repository.CategoriesRepository;
import kickstarter.repository.QuotesRepository;

public class CategoriesPage extends Page {

	// private Storage<Quote> quotes;

	final int ERROR_PAGE = 3;
	final int PROJECTS = 1;
	QuotesRepository quotesRepository;
	CategoriesRepository categories;

	public CategoriesPage(CategoriesRepository categories,
			QuotesRepository quotesRepository) {
		this.categories = categories;
		this.quotesRepository = quotesRepository;

	}

	public String getHeader() {
		Quote randomQuote = quotesRepository.getRandomQuote();
		String header = "";
		header += "\n-----Quote------";
		header += "\n" + randomQuote.getQuote();
		header += "\n----------------";
		header += "\n=========================";
		header += "\n|     Categories        |";
		header += "\n=========================";
		header += "\n";
		header += categories.getListAllCategories();
		header += "\n------------------------";
		return header;
	}

	public void print() {

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