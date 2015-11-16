package ua.com.goit.gojava7.kikstarter;

/**
 * create class Quote which contain list quotes
 * 
 */
public class Quote {

	private String quoteContent;
	private String quoteAuthor;

	public Quote() {
	}

	public String getQuoteContent() {
		return quoteContent;
	}

	public String getQuoteAuthor() {
		return quoteAuthor;
	}

	public void setQuoteContent(String quoteContent) {
		this.quoteContent = quoteContent;
	}

	public void setQuoteAuthor(String quoteAuthor) {
		this.quoteAuthor = quoteAuthor;
	}

}
