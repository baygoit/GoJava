package home.Kickstarter.ContentManagement;
import home.Kickstarter.Content.Quote;

import java.util.List;

public class ContentManager implements QouteManagement{

	private QouteStorage qouteStorage;
	private Quote quote;
	
	public ContentManager(QouteStorage qouteStorage) {
		this.qouteStorage = qouteStorage;
	}
	
	@Override
	public void createQoute(String content, String author) {
		quote = new Quote(content, author);
		qouteStorage.addQouteToStorage(quote);
	}
	
	@Override
	public List<Quote> getQoutes() {
		return qouteStorage.getQuotes();
	}
	
	@Override
	public QouteStorage getStorage() {
		return qouteStorage;
	}
}
