package kickstarter.entities;

import java.io.Serializable;

public class Quote implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7060451318379559888L;
	private String quote = "";

	public void setQuote(String quote) {
		String newQuote = new String(quote);
		this.quote = newQuote;
	}
	public String getQuote() {
		return quote;
	}
}
