package kickstarter.data_types;

public class Quote implements Data {
	private String quote;

	public Quote(String quote) {
		this.quote = quote;
	}

	@Override
	public int getId() {
		throw new UnsupportedOperationException();
	}
	
	public String getQuote() {
		return quote;
	}
}
