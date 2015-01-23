package home.Kickstarter.Kickstarter;
import home.Kickstarter.Content.Quote;
import home.Kickstarter.ContentManagement.QouteStorage;

import java.util.List;

public class Kickstarter {
	
	private final String title = "\t************ Kickstarter ************";
	private QouteStorage qouteStorage;
	
	public Kickstarter(QouteStorage qouteManager) {
		this.qouteStorage = qouteManager;
	}
	
	public void printTitel() {
		System.out.println(title);
	}
	
	public void displayQoute() {
		List<Quote> quotes = qouteStorage.getQuotes();
		for(Quote q: quotes) {
			System.out.println(q.getContent() + ""+ q.getOwner()); // TODO in UI circle change on anothe qoute 
		}
	}
}