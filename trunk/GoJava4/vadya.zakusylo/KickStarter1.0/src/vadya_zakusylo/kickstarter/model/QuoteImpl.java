package vadya_zakusylo.kickstarter.model;

public class QuoteImpl implements Quote {
	private String quote;
	private String author;

	public QuoteImpl(String quote, String author) {
		this.quote = quote;
		this.author = author;
	}

	@Override
	public String getQuote() {
		return quote + "\n\t\t" + author;
	}
}
