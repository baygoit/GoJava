package vadyazakusylo.kickstarter.model;

public class Quote {
	private String quote;
	private String author;

	public Quote(String quote, String author) {
		this.quote = quote;
		this.author = author;
	}

	public String getQuote() {
		return quote + "\n\t\t" + author;
	}
}
