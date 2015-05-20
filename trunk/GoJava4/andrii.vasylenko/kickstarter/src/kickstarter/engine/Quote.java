package kickstarter.engine;

public class Quote implements Data {

	private static int count = 0;

	private int id;
	private String quote;

	public Quote(String quote) {
		if (quote == null) {
			throw new IllegalArgumentException();
		}
		this.id = count++;
		this.quote = quote;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getQuote() {
		return quote;
	}
}
