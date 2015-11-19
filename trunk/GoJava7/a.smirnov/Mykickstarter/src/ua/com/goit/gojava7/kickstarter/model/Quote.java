package ua.com.goit.gojava7.kickstarter.model;

import java.io.Serializable;

public class Quote implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String quoteText;
	private String author;
	
	public Quote(String quoteText, String author) {
		this.quoteText = quoteText;
		this.author = author;
	}

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
	
	@Override
	public String toString() {
		return getQuoteText();
	}
}
