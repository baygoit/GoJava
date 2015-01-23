package home.Kickstarter.ContentManagement;
import home.Kickstarter.Content.Quote;

import java.util.List;

public interface QouteManagement {
	
	public void createQoute(String content, String author);
	public List<Quote> getQoutes();
	public QouteStorage getStorage();
}