package belskii.artem.kickstarter.dao.quote;

public interface QuoteDao {
	public String getRandomQuote();
	public void addQuote(String text);
}
