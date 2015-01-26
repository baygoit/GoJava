package home.GoJava2.Engine;
import home.GoJava2.Content.Quote;
import home.GoJava2.DataBase.QuoteStorage;

public interface QuoteManagement {
	
	public void createQuote(String content, String author);
	public Quote getQuote();
	public QuoteStorage getQuoteStorage();
}