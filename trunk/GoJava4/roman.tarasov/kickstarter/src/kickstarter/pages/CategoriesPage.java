package kickstarter.pages;

import kickstarter.entities.Quote;
import kickstarter.mvc.Model;
import kickstarter.mvc.iNavigator;
import kickstarter.repository.CategoriesRepository;
import kickstarter.repository.QuotesRepository;

public class CategoriesPage extends Page {

	final int ERROR_PAGE = 3;
	final int PROJECTS = 1;
	QuotesRepository quotesRepository;
	CategoriesRepository categories;
	iNavigator navigator;
	final int THIS_PAGE=0;    //categories
	final int NEXT_PAGE=1;    //projects
	final int PREVIOUS_PAGE=4;//the end

	public CategoriesPage(CategoriesRepository categories,
			QuotesRepository quotesRepository, Model model) {
		this.categories = categories;
		this.quotesRepository = quotesRepository;
		navigator=model;
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
		header += categories.getListAllCategories();
		header += "\n------------------------";
		header += "\n  p- previous page";
		return header;
	}

	public void viewWorkedStatus(int status) {
	}

	public String[] getOptions() {
		return options;
	}

	public void execute(String message) {
		if(message.equals("p")){
			navigator.pageWillBe(PREVIOUS_PAGE);
			return;
		}
		options = categories.getStringOptions();
		optionsInt = categories.getIntOptions();
		if (options != null) {
			for (int index = 0; index < options.length; index++) {
				if (message.equals(options[index])) {
					navigator.pageWillBe(NEXT_PAGE);
					navigator.setOption(optionsInt[index],options[index]);
					
					return;
				}
			}
		}
		navigator.pageWillBe(ERROR_PAGE); 
	}
}