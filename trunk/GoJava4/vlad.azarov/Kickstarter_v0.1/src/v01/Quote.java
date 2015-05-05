package v01;

public class Quote {
	
	private static String quote = "Inspiring quote #1";
	
	public Quote(String quote) {
		this.quote = quote;
	}
	
	public static String getQuote() {
		return quote;
	}
}