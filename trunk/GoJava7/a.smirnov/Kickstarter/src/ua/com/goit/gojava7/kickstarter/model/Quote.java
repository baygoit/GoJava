package ua.com.goit.gojava7.kickstarter.model;

public class Quote {

	private String author;
	private String quoteText;

	public void setQuoteText(String title) {
		this.quoteText = title;
	}

	public String getQuoteText() {
		return quoteText;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}
}
