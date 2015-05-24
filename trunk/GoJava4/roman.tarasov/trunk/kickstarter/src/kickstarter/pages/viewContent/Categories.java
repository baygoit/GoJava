package kickstarter.pages.viewContent;

import kickstarter.entities.Quote;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ViewOptions;
import kickstarter.repository.facade.Repository;

public class Categories extends PageView {

	public Categories(Repository repository, iModel imodel) {

		this.imodel = imodel;
		this.repository = repository;
	}

	public String getHeader() {

		Quote quote = repository.getRandomQuote();
		StringBuilder header = new StringBuilder();
	
		header.append("\n-----Quote------");
		header.append("\n");
		header.append(quote.getQuote());
		header.append("\n----------------");
		header.append("\n=========================");
		header.append("\n|     Categories        |");
		header.append("\n=========================");
		header.append("\n");
		header.append(getListAllCategories());
		header.append("\n------------------------");
		header.append("\nSelect category by ID:<ID>");
		header.append("\nOptions:  <e> - The End");
		return header.toString();
	}

	public String getListAllCategories() {
		String result = "";
		int length = repository.getCategoriesLength();
		strOptions = new String[length];
		intOptions = new int[length];
		for (int index = 0; index < length; index++) {

			result += ("ID:<" + repository.getCategory(index).ID + "> name:<"
					+ repository.getCategory(index).name + ">\n");
			strOptions[index] = Integer
					.toString(repository.getCategory(index).ID);
			intOptions[index] = repository.getCategory(index).ID;
		}
		ViewOptions viewOptions = imodel.getViewOptions();
		viewOptions.intCategories = intOptions;
		viewOptions.strCategories = strOptions;
		imodel.setViewOptions(viewOptions);
		return result;
	}
}