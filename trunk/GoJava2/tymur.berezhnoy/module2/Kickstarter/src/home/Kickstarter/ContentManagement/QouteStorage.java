package home.Kickstarter.ContentManagement;
import home.Kickstarter.Content.Quote;

import java.util.ArrayList;
import java.util.List;

public class QouteStorage {
	private List<Quote> listOfQoutes = new ArrayList<Quote>();
	
	public void addQouteToStorage(Quote quote) {
		listOfQoutes.add(quote);
	}
	
	public List<Quote> getQuotes() {
		return listOfQoutes;
	}
}
