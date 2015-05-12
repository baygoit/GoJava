package pages;

import java.util.ArrayList;

import datasource.DataSource;
import entities.Quote;
import kickstarter.Kickstarter;

public class MainPage implements Page {
	private DataSource dataSource = Kickstarter.getDataSource();
	private Quote quote = dataSource.getSomeQuote();
	private ArrayList<String> Categorys = dataSource.getCategorysList();
	private ArrayList<String> page = new ArrayList<String>();
	
	@Override
	public String[] getPage() {
		page.add(quote.getQuote());
		page.add("");
		return page;
	}

}
