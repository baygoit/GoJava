package kickstarter.pages.viewContent;

import java.util.List;

import kickstarter.entities.Category;
import kickstarter.entities.Quote;
import kickstarter.mvc.viewState.ViewValues;
import kickstarter.repository.facade.RepositoryException;

public class Categories extends PageView {

	public String getHeader() throws RepositoryException {

		StringBuilder header = new StringBuilder();

		header.append("\n-----Quote------");
		header.append("\n");
		try {
			Quote quote = repository.getRandomQuote();
			header.append(quote.getQuote());
		} catch (NullPointerException e) {
			throw new RepositoryException();
		}

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
		strValues = new String[length];
		intValues = new int[length];
		for (int index = 0; index < length; index++) {
			Category currentCategory = listAllCategories.get(index);
			result += ("ID:<" + currentCategory.ID + "> name:<"
					+ currentCategory.name + ">\n");
			strValues[index] = Integer.toString(currentCategory.ID);
			intValues[index] = currentCategory.ID;
		}
		ViewValues ViewValues = iview.getViewValues();
		ViewValues.intCategories = intValues;
		ViewValues.strCategories = strValues;
		return result;
	}
}