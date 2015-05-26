package kickstarter.pages.viewContent;

import java.util.List;

import kickstarter.entities.Category;
import kickstarter.entities.Quote;
import kickstarter.mvc.options.ViewOptions;
import kickstarter.repository.facade.RepositoryException;

public class Categories extends PageView {


	public String getHeader() throws RepositoryException {

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
		header.append("\nOptions:  <r> - Repository menu;  <e> - The End");
		return header.toString();
	}

	public String getListAllCategories() throws RepositoryException {
		String result = "";

		List<Category> listAllCategories = repository.getListAllCategories();
		int length = listAllCategories.size();
		strOptions = new String[length];
		intOptions = new int[length];
		for (int index = 0; index < length; index++) {
			Category currentCategory = listAllCategories.get(index);
			result += ("ID:<" + currentCategory.ID + "> name:<"
					+ currentCategory.name + ">\n");
			strOptions[index] = Integer.toString(currentCategory.ID);
			intOptions[index] = currentCategory.ID;
		}
		ViewOptions viewOptions = imodel.getViewOptions();
		viewOptions.intCategories = intOptions;
		viewOptions.strCategories = strOptions;
		imodel.setViewOptions(viewOptions);
		return result;
	}
}