package data_types;

public class Quote implements Data {
	private String quote;

	public Quote(String quote) {
		this.quote = quote;
	}

	@Override
	public int getId() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String toString() {
		return "Quote: " + quote;
	}
}
