package kickstarter.pages.viewContent;


import kickstarter.entities.Quote;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ViewOptions;
import kickstarter.repository.facade.Repository;

public class Categories extends PageView {

	public Categories( Repository repository, iModel imodel) {

		this.imodel = imodel;
		this.repository=repository;
	}

	public String getHeader() {
		
		
		Quote quote = repository.getRandomQuote();
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
		ViewOptions vo =imodel.getViewOptions(); 
		vo.intCategories = intOptions;
		vo.strCategories = strOptions;
		imodel.setViewOptions(vo);
		return result;
	}
}