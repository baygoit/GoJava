package kickstarter.model.entity;

public class Quote {
	private int id;
	private String quote;

	public Quote(int id, String quote) {
		this.id = id;
		this.quote = quote;
	}

	public int getId() {
		return id;
	}

	public String getQuote() {
		return quote;
	}
}
