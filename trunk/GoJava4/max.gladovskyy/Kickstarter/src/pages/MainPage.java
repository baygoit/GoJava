package pages;

import java.util.ArrayList;

import datasource.DataSource;
import entities.Category;
import kickstarter.Kickstarter;

public class MainPage implements Page {
	private DataSource dataSource = Kickstarter.getDataSource();
	private ArrayList<Category> categories = dataSource.getCategoriesList();
	private ArrayList<String> page = new ArrayList<String>();
	
	@Override
	public ArrayList<String> getPage() {
		page.add(dataSource.getSomeQuote());
		page.add("");
		page.add("Plese choose category from list below:");
		for (Category category : categories) {
			page.add(categories.indexOf(category)+1+") "+category.getName());
		}
		return page;
	}

}
