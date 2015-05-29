package kickstarter.pages.viewContent;

import java.util.List;

import kickstarter.mvc.viewState.ViewValues;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.entity.Category;
import kickstarter.repository.facade.entity.Quote;

public class Categories extends PageView {

	public String getHeader() throws RepositoryException {

		StringBuilder header = new StringBuilder();

		header.append("\n-----Quote------");
		header.append("\n");
		try {
			Quote quote = repository.getRandomQuote();
			header.append(quote.getQuote());
		} catch (NullPointerException e) {
			throw new RepositoryException("");
		}

		header.append("\n----------------");
		header.append("\n=========================");
		header.append("\n|     Categories        |");
		header.append("\n=========================");
		header.append("\n");
		header.append(getListAllCategories());
		header.append("\n------------------------");
		header.append("\nSelect category by ID:<ID>");
		header.append("\nOptions:  <r> - MemoryRepository menu;  <e> - The End");
		return header.toString();
	}

	public String getListAllCategories() throws RepositoryException {

		StringBuilder result = new StringBuilder();
		List<Category> listAllCategories = repository.getListAllCategories();
		int length = listAllCategories.size();
		strValues = new String[length];
		intValues = new int[length];
		for (int index = 0; index < length; index++) {
			Category currentCategory = listAllCategories.get(index);

			result.append("ID:<");
			result.append(currentCategory.getID());
			result.append("> name:<");
			result.append(currentCategory.getName());
			result.append(">\n");

			strValues[index] = Integer.toString(currentCategory.getID());
			intValues[index] = currentCategory.getID();
		}
		ViewValues ViewValues = iview.getViewValues();
		ViewValues.setIntCategories(intValues);
		ViewValues.setStrCategories(strValues);
		return result.toString();
	}
}