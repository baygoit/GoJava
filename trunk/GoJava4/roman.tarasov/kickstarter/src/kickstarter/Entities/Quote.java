package kickstarter.Entities;

public class Quote {
	private String quote = "";

	public void setQuote(String quote) {
		String newQuote = new String(quote);
		this.quote = newQuote;
	}

	public String getQuote() {
		return quote;
	}

}
