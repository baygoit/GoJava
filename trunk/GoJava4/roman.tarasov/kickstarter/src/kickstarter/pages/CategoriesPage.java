package kickstarter.pages;

import kickstarter.entities.Quote;
import kickstarter.mvc.Model;
import kickstarter.repository.CategoriesRepository;
import kickstarter.repository.QuotesRepository;

public class CategoriesPage extends Page {

	public CategoriesPage(CategoriesRepository categories,
			QuotesRepository quotesRepository, Model model) {
		this.categories = categories;
		this.quotesRepository = quotesRepository;
		navigator = model;
	}

	public String getHeader() {
		Quote quote = quotesRepository.getRandomQuote();
		String header = "";
		header += "\n-----Quote------";
		header += "\n" + quote.getQuote();
		header += "\n----------------";
		header += "\n=========================";
		header += "\n|     Categories        |";
		header += "\n=========================";
		header += "\n";
		header += getListAllCategories();
		header += "\n------------------------";
		header += "\nSelect category by ID:<ID>";
		header += "\nOptions:  <e> - The End";
		return header;
	}

	public String getListAllCategories() {
		String result = "";
		int length = categories.getCategoriesLength();
		options = new String[length];
		optionsInt = new int[length];
		for (int index = 0; index < length; index++) {

			result += ("ID:<" + categories.getCategory(index).ID + "> name:<"
					+ categories.getCategory(index).name + ">\n");
			options[index] = Integer.toString(categories.getCategory(index).ID);
			optionsInt[index] = categories.getCategory(index).ID;
		}
		return result;
	}

	public void viewWorkedStatus(int status) {
	}

	public String[] getOptions() {
		return options;
	}

	public void execute(String message) {
		if (message.equals("e")) {
			navigator.pageWillBe(END_PAGE);
			return;
		}

		if (options != null) {
			for (int index = 0; index < options.length; index++) {
				if (message.equals(options[index])) {
					navigator.pageWillBe(PROJECTS);
					
					navigator.setOption(optionsInt[index], options[index]);

					return;
				}
			}
		}
		navigator.savePageBeforeError(CATEGORIES);
		navigator.pageWillBe(ERROR_PAGE);
	}
}