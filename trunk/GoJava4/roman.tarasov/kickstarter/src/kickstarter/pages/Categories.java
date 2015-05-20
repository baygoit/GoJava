package kickstarter.pages;

import kickstarter.entities.Quote;
import kickstarter.mvc.iModel;
import kickstarter.pages.model.ViewOptions;
import kickstarter.repository.CategoriesRepository;
import kickstarter.repository.QuotesRepository;

public class Categories extends PageView {

	public Categories(CategoriesRepository categories,
			QuotesRepository quotesRepository, iModel imodel) {
		this.categories = categories;
		this.quotesRepository = quotesRepository;
		this.imodel = imodel;
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
		strOptions = new String[length];
		intOptions = new int[length];
		for (int index = 0; index < length; index++) {

			result += ("ID:<" + categories.getCategory(index).ID + "> name:<"
					+ categories.getCategory(index).name + ">\n");
			strOptions[index] = Integer
					.toString(categories.getCategory(index).ID);
			intOptions[index] = categories.getCategory(index).ID;
		}
		ViewOptions vo = new ViewOptions();
		vo.intOptions = intOptions;
		vo.strOptions = strOptions;
		imodel.setViewOptions(vo);
		return result;
	}
}