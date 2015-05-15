package kickstarter.pages;

import kickstarter.entities.Category;
import kickstarter.entities.Quote;
import kickstarter.repository.Storage;
import kickstarter.ui.UserInterface;

public class CategoriesPage extends Page {
	private Storage<Category> categories;
	private Storage<Quote> quotes;
	private UserInterface ui;

	public CategoriesPage(Storage<Category> categories, UserInterface ui,Storage<Quote> quotes) {
		this.categories = categories;
		this.quotes=quotes;
		this.ui = ui;
	}

	public void print(int[] parameterForPrint) {
		print();
	}

	public void print() {
		Quote randomQuote = quotes.getRandom();
		ui.display("-----Quote------");
		ui.display(randomQuote.getQuote());
		ui.display("----------------");
		
		ui.display("=========================");
		ui.display("|     Categories        |");
		ui.display("=========================");

		int pointer = categories.length();
		options = new int[pointer];
		for (int index = 0; index < pointer; index++) {

			ui.display("ID:<" + categories.getEntity(index).ID + "> name:<"
					+ categories.getEntity(index).name + ">");
			options[index] = categories.getEntity(index).ID;
		}
		ui.display("------------------------");
	}

	public int[] getOptions() {
		return options;
	}
}